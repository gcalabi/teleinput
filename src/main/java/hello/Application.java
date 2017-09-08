package hello;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("solo socket");
        escuchar();
        /*String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/
    }

    private static void escuchar() {


        Thread two = new Thread() {
            public void run() {
                try {
                    //System.out.println("Does it work?");


        try {

            System.out.println("Listening for connection on port 8081 ....");
            final ServerSocket server = new ServerSocket(8081);
            // spin forever
            while (true) {
                Socket clientSocket = server.accept();
                Thread one = new Thread() {
                    public void run() {
                        try {
                            System.out.println("Entro conexion");
                            try {

                                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                                BufferedReader reader = new BufferedReader(isr);
                                String line = reader.readLine();
                                if (line != null && !line.isEmpty()) {
                                    System.out.println(line);
                                    //line = reader.readLine();
                                    //  System.out.println("IP :" + clientSocket.getInetAddress());


                                }
                                Date today = new Date();
                                String httpResponse = "Hola Fecha \n";
                                System.out.println("por mandar");
                                //sleep(2000);
                                clientSocket.getOutputStream().write(httpResponse.getBytes());
                                clientSocket.getOutputStream().write("Segunda linea".getBytes());
                                System.out.println("listo");
                               // sleep(6000);
                                System.out.println("dp sleep");
                                //clientSocket.close();
                                // server.close();
                            } catch (Exception e) {
                                System.out.println(e.toString());
                            }
                            System.out.println("Nope, it doesnt...again.");
                        } catch (Exception v) {
                            System.out.println(v);
                        }


                    }
                };
                one.start();
            }
        } catch (Exception v) {
            System.out.println(v);
        }
                    System.out.println("Nope, it doesnt...again.");
                } catch (Exception v) {
                    System.out.println(v);
                }


            }
        };
        two.start();

    }

}
