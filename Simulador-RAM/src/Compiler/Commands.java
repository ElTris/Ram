/**
 * @autor PiCode
 * Compilador del editor.
 */

package Compiler;
import java.util.Map;
import java.util.TreeMap;

class Commands
{
    public static Map<String, Boolean> command = new TreeMap<String, Boolean>(); // Diccionario de comandos
    private static Map<String, Boolean> dirmod = new TreeMap<String, Boolean>(); // Modos de direccionamiento
    public static long ac; // Acumulador del programa
    public static String puntero; // Puntero a valores
    
    Commands()
    {
        ac = 0;
        puntero = "0";
        supportCommand();
        dirmod.put("*", mod());
        dirmod.put("**", mod());
    }
    
    /**
     * Aquí se ponen los comandos que va a soportar el editor,
     * deben de estar asociados a la función que deben cumplir.
     */
    private void supportCommand()
    {
        command.put("READ", true);
        command.put("LOAD", load());
        command.put("STORE", store());
        command.put("ADD", add());
        command.put("SUB", sub());
        command.put("MUL", mul());
        command.put("DIV", div());
        command.put("INC", inc());
        command.put("DEC", dec());
        command.put("JUMP", jump());
        command.put("JEZ", jez());
        command.put("JNEZ", jnez());
        command.put("WRITE", write());
        command.put("HALT", halt());
    }
    
    
    private boolean mod()
    {
        String direccion;
        boolean estado = true;
        
        if(puntero.compareTo("**") > 0)
            estado = false;
        else if(puntero.compareTo("**") == 0)
        {
            direccion = puntero.substring(2, puntero.length());
            indirect(direccion);
            estado = true;
        }
        else if(puntero.compareTo("*") == 0)
        {
            direccion = puntero.substring(1, puntero.length());
            direct(direccion);
            estado = true;
        }
        return estado;
    }
    
    private int direct(String direccion)
    {
        return 1;
    }
    
    private int indirect(String direccion)
    {
        return 1;
    }
    
    
    private boolean read()
    {
        return true;
    }
    private boolean load()
    {
        return true;
    }
    private boolean store()
    {
        return true;
    }
    private boolean add()
    {
        return true;
    }
    private boolean sub()
    {
        return true;
    }
    private boolean mul()
    {
        return true;
    }
    private boolean div()
    {
        return true;
    }
    private boolean inc()
    {
        return true;
    }
    private boolean dec()
    {
        return true;
    }
    private boolean jump()
    {
        return true;
    }
    private boolean jez()
    {
        return true;
    }
    private boolean jnez()
    {
        return true;
    }
    private boolean write()
    {
        return true;
    }
    private boolean halt()
    {
        return true;
    }
}