/**
 * @autor Josue
 * Manejo de los datos que se consideran como registros en el programa inicial
 */

package Compiler;

public class Memory
{
    private int ac; // Acumulador de la memoria
    private byte counter; // Contador de registros
    private byte pointer; // Puntero de registros
    private int[] registers; // Tabla de registros
    
    /**
     * Constructor Data
     */
    Memory()
    {
        ac = counter = pointer = 0;
        registers = new int[80];
        for(int a:registers)
            a = 0;
    }
    
    /**
     * get ac
     * @return El valor actual del acumulador
     */
    public int getAC()
    {
        return ac;
    }
    
    /**
     * set ac
     * Si no puede almacenar el valor por default es 0
     * @param _value Valor que tendrá el acumulador
     */
    public void setAC(int _value)
    {
        try
        {
            ac = _value;
        }
        catch(Exception e)
        {
            ac = 0;
        }
    }
    
    /**
     * get counter
     * @return Valor del contador actualmente
     */
    public byte getCounter()
    {
        return counter;
    }
    
    /**
     * get pointer
     * @return Dirección de un registro
     */
    public byte getPointer()
    {
        return pointer;
    }
    
    /**
     * set pointer
     * Si no puede almacenar la dirección por default es la 0
     * @param _pointer Puntero a un registro
     */
    public void setPointer(byte _pointer)
    {
        try
        {
            pointer = _pointer;
        }
        catch(Exception e)
        {
            pointer = 0;
        }
    }
    
    /**
     * get registers
     * @return Valor del registros indicado
     */
    public int getRegister()
    {
        int _value;
        try
        {
            _value = registers[pointer];
        }
        catch(Exception e)
        {
            _value = 0;
        }
        return _value;
    }
    
    /**
     * set registers
     * @param _value Valor que se introducirá en el registro donde se localice el contador
     * @return Indica el procedimiento fue exitoso o no
     */
    public boolean setRegister(int _value)
    {
        boolean _state;
        try
        {
            registers[counter] = _value;
            counter++;
            _state = true;
        }
        catch(Exception e)
        {
            _state = false;
        }
        return _state;
    }
    
    /**
     * Método para borrar registros
     * @return Indica si el procedimiento fue exitoso o no
     */
    public boolean deleteRegister()
    {
        boolean _state;
        try{
            for( ; pointer < counter + 1; pointer++)
                registers[pointer] = registers[pointer + 1];
            counter--;
            _state = true;
        }
        catch(Exception e)
        {
            _state = false;
        }
        return _state;
    }
}
