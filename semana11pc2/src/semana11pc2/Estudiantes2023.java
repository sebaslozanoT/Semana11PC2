package semana11pc2; 
import java.util.*;
import javax.swing.*;
import java.io.*;
public class Estudiantes2023 {
    private static ArrayList<Estudiante> estudiantes;

    public Estudiantes2023() {
        estudiantes = new ArrayList<>();
        cargarArchivo(); // Carga los estudiantes desde un archivo
    }

    public void adicionar(Estudiante estudiante) {
        estudiantes.add(estudiante); // Agrega un estudiante a la lista
    }

    public void eliminar(Estudiante estudiante) {
        if (tamano() > 0)
            estudiantes.remove(estudiante); // Elimina un estudiante de la lista si hay estudiantes
    }

    public void registrar(Estudiante estudiante) {
        // Registra un nuevo estudiante
        Estudiante estudiante1 = estudiantes.get(tamano() - 1);
    }

    // ... otros métodos ...

    // M?todos para manipular el archivo de texto
    private void readFromInputStream(InputStream inputStream) throws IOException {
        // Lee y procesa el archivo de estudiantes desde un flujo de entrada
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        // ... el resto del código
    }

    // M?todo que a?adir a los estudiantes del archivo .txt en el arrayList estudiantes.
    private void createStudent(StringTokenizer st) {
        // Crea un objeto Estudiante a partir de los datos del archivo
        // ... el resto del código
    }

    // M?todos para manipular el archivo de texto
    private void cargarArchivo() {
        try {
            File file = new File("./src/semana11pc2/estudiantes.txt");
            Class<Estudiantes2023> clazz = Estudiantes2023.class;
            InputStream inputStream = clazz.getResourceAsStream("/semana11pc2/estudiantes.txt");
            if (file.exists()) {
                readFromInputStream(inputStream);
            } else
                JOptionPane.showMessageDialog(null, "El archivo estudiantes.txt no existe");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
        }
    }
}
