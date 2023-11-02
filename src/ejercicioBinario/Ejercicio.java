package ejercicioBinario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio {
	
	ArrayList<A> lista = new ArrayList<A>();
	//var m = new main();
	
	Random rn = new Random();
	//https://www.geeksforgeeks.org/java-string-join-examples/
	
	public void addList() throws IOException {
		lista.add(generarA("Pepe", 2, 7, 9, 12));
		lista.add(generarA("Juan", 0, 1, 5, 10));
		lista.add(generarA("Pablo Garcia", 4, 9, 0, 1));
		lista.add(generarA("Vacio", 0, 1, 0, 1));
		escribirFichero(lista);
		escribirBinario(lista);
		ArrayList<A> prueba = leerFichero("archivo.txt");
		leerFicheroBinario("datos.dat");
		System.out.println();
	}

	private ArrayList<A> leerFichero(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            ArrayList<A> lista = new ArrayList<A>();
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(";");
                System.out.println(partes[0]);
                System.out.println(partes[1]);
                System.out.println(partes[2]);
                
                ArrayList<Integer> listaB = new ArrayList<>();
                ArrayList<Integer> listaC = new ArrayList<>();

                if (!partes[1].equals("0")) {
                    String[] numB = partes[1].split(",");
                    for (String x : numB) {
                        listaB.add(Integer.parseInt(x));
                    }
                }

                if (!partes[2].equals("0")) {
                    String[] numC = partes[2].split(",");
                    for (String x : numC) {
                        listaC.add(Integer.parseInt(x));
                    }
                }
                lista.add(new A(listaB, listaC, partes[0]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return lista;
	}

	private A generarA(String nombre, int minimoB, int maximoB, int minimoC, int maximoC) {
		int minValue = 147483647;
		int maxValue = 1147483647;
		var tamB = rn.nextInt(minimoB, maximoB);
		var tamC = rn.nextInt(minimoC, maximoC);
		ArrayList<Integer> b = new ArrayList<Integer>(tamB);
		ArrayList<Integer> c = new ArrayList<Integer>(tamC);
	
		for (int i = 0; i < tamB; i++) {
			b.add(rn.nextInt(minValue, maxValue));
		}
		for (int i = 0; i < tamC; i++) {
			c.add(rn.nextInt(minValue, maxValue));
		}
		return new A(b, c, nombre);
	}
	
	
	private void escribirFichero(ArrayList<A> lista) throws IOException {
		File file = new File("archivo.txt");
		file.delete();
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    for (A objetoA : lista) {
	        bufferedWriter.write(objetoA.nombre);
	        bufferedWriter.write(';');
	        List<Integer> listaB = objetoA.getB();
	        int tamaño = listaB.size();
	        if(objetoA.getB().size() == 0) {
	        	bufferedWriter.write(String.valueOf(0));
	        }else {
	        	for (int i = 0; i < tamaño; i++) {
		            Integer valor = listaB.get(i);
		            bufferedWriter.write(String.valueOf(valor));

		            if (i < tamaño - 1) {
		                bufferedWriter.write(',');
		            }
		        }
	        }	        
	        bufferedWriter.write(';');
	        List<Integer> listaC = objetoA.getC();
	        tamaño = listaC.size();
	        if(objetoA.getC().size() == 0) {
	        	bufferedWriter.write(String.valueOf(0));
	        }else {
	        	for (int i = 0; i < tamaño; i++) {
		            Integer valor = listaC.get(i);
		            bufferedWriter.write(String.valueOf(valor));

		            if (i < tamaño - 1) {
		                bufferedWriter.write(',');
		            }
		        }
	        }	        
	        bufferedWriter.newLine();
	    }
	    bufferedWriter.write("");
	    bufferedWriter.close();
	    fileWriter.close();
	}
	
	private void escribirBinario(ArrayList<A> lista) throws IOException {
		FileOutputStream  fos = new FileOutputStream("datos.dat");
		DataOutputStream salida = new DataOutputStream(fos);
		for(A a: lista) {
			salida.writeUTF(a.getNombre());
			for(Integer b:a.b) {
				salida.writeInt(b);
			}
			for(Integer c:a.c) {
				salida.writeInt(c);
			}
		}
		salida.close();
		fos.close();
	}
	
	private ArrayList<A> leerFicheroBinario(String filePath){
		return lista;
		
	} 
}
