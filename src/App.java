import java.io.BufferedWriter;
import java.io.FileWriter;

public class App {
    // Función para imprimir todos los números binarios de n dígitos sin ningún 1 consecutivo
    public static void countStrings(int n, String out, int last_digit)
    {
        

        // si el número se convierte en n-dígito, imprímelo
        if (n == 0)
        {
            FileWriter fw = null;
            BufferedWriter bw = null;

            try {
                fw = new FileWriter("C:/Users/Darwin/Documents/Github/java count binary/CountBinary/file.txt", true);
                bw = new BufferedWriter(fw);
                //Writing to the file
                bw.write(out);
                bw.newLine();
                //Closing the stream
                bw.close();
            }
            //Handing Exception
            catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return;
        }
 
        // agregar 0 al resultado y repetir con un dígito menos
        countStrings(n - 1, out + '0', 0);
 
        // agregar 1 al resultado y repetir con un dígito menos
        countStrings(n - 1, out + '1', 1);
    }
 
    public static void main(String[] args)
    {
        // número total de dígitos
        int n = 10;
 
        String out = "";
        countStrings(n, out, 0);
    }
}
