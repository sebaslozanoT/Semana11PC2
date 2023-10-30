package semana11pc2; 
import java.util.*;
import javax.swing.*;
import java.io.*;

public class Estudiantes2023 {
    private static ArrayList<Estudiante> estudiantes;

    public Estudiantes2023() {
        estudiantes = new ArrayList<>();
        cargarArchivo();
    }

    public void adicionar(Estudiante estudiante) {
        //Introducestudiantese c?digo
        estudiantes.add(estudiante);
    }

    public void eliminar(Estudiante estudiante) {
        //Introduce c?digo
        if( tamano()>0)
        estudiantes.remove(estudiante);
    }
    public void registrar(Estudiante estudiante){
       //1. buscar al estudiante al ultimo estudiante.
       Estudiante estudiante1 = estudiantes.get(tamano()-1);
       
       
    }

    public Estudiante obtener(int pos) {
	//Introduce c?digo
       
        return null;
    }

    public Estudiante buscar(int codigo) {
	//Introduce c?digo
        /*for(int i = 0; i< estudiantes.size();i++);
            if(codigo == estudiantes.get().getCodigo())
                return estudiantes.get(1);
	  return null;*/
    }

    public int tamano() {
        //Introduce c?digo
	  return estudiantes.size();
    }

    public void listarEstudiantes(){
        //Introduce c?digo
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }
    }

    // M?todos para manipular el archivo de texto
    private void readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(linea, ",");
            createStudent(st);
        }
        br.close();
    }

	// M?todo que a?adir a los estudiantes del archivo .txt en el arrayList estudiantes.
    private void createStudent(StringTokenizer st){
        int codigo = Integer.parseInt(st.nextToken().trim());
        String nombre = st.nextToken().trim();
        int ciclo = Integer.parseInt(st.nextToken().trim());
        double pension = Double.parseDouble(st.nextToken().trim());
        Estudiante estudiante = new Estudiante(codigo, nombre, ciclo, pension);
        adicionar(estudiante);
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
                JOptionPane.showMessageDialog(null,
                        "El archivo estudiantes.txt no existe");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
        }
    }
}