package project;

import java.util.Scanner;

public class ArtikaVentas {
    //ESTE MÉTODO LO USAMOS PARA ORDENAR Y SACAR UNRANKING DE TOP VENDEDORES MENSUAL DE LA EMPRESA
    public static void ordenamientoPorVentas(String[] arregloNombres , int[] arreglosVentas){

        for(int i=0 ; i<=arreglosVentas.length-2 ; i++){
            for(int j=1 ; j<=arreglosVentas.length-1 ; j++){
                if(arreglosVentas[j]>arreglosVentas[j-1]){
                    int temporal = arreglosVentas[j];
                    arreglosVentas[j] = arreglosVentas[j-1];
                    arreglosVentas[j-1] = temporal;

                    String nombresTemporal = arregloNombres[j];
                    arregloNombres[j] = arregloNombres[j-1];
                    arregloNombres[j-1] = nombresTemporal;
                }
            }
        }
    }

    //METODO USADO PARA IMPRIMIR LA LISTA DE RESULTADOS
    public static void imprimir(String[] arregloNombre , int[] arregloVentas){

        for(int i=0 ; i<= arregloNombre.length-1 ; i++){
            System.out.println(arregloNombre[i] + " : " + arregloVentas[i]);
        }
    }

    //ESTE MEOTDO USAMOS PARA SEPARAR LOS TOP Y CLASIFICARLOS DE ACUERDOS A LOS BENEFICIOS
    public static void listaGanadores(String[] arregloNombre , int[] arregloVentas){
        ordenamientoPorVentas(arregloNombre , arregloVentas);
        System.out.println("Los ganadores de los 50 soles fueron: ");
        for(int i=0 ; i<= arregloVentas.length-1 ; i++){
            if(arregloVentas[i]>= 1800 && arregloVentas[i]<2500){
                System.out.println(arregloNombre[i]+ " : " + arregloVentas[i]);
            }
        }

        System.out.println();

        System.out.println("Los ganadores de los 80 soles fueron: ");
        for(int i=0 ; i<= arregloVentas.length-1 ; i++){
            if(arregloVentas[i]>= 2500 && arregloVentas[i]<4000){
                System.out.println(arregloNombre[i]+ " : " + arregloVentas[i]);
            }
        }

        System.out.println();

        System.out.println("Los ganadores de los 120 soles fueron: ");
        for(int i=0 ; i<= arregloVentas.length-1 ; i++){
            if(arregloVentas[i]>= 4000 && arregloVentas[i]<6000){
                System.out.println(arregloNombre[i]+ " : " + arregloVentas[i]);
            }
        }

        System.out.println();

        System.out.println("Los ganadores de los 200 soles fueron: ");
        for(int i=0 ; i<= arregloVentas.length-1 ; i++){
            if(arregloVentas[i]>= 6000 && arregloVentas[i]<12000){
                System.out.println(arregloNombre[i]+ " : " + arregloVentas[i]);
            }
        }

        System.out.println();

        System.out.println("Los ganadores del viaje a Máncora fueron: ");
        for(int i=0 ; i<= arregloVentas.length-1 ; i++){
            if(arregloVentas[i]>= 15000 ){
                System.out.println(arregloNombre[i]+ " : " + arregloVentas[i]);
            }
        }
    }


    public static int ventasMensuales(int[] arregloVentas , int posicion){
        if(posicion >= arregloVentas.length-1) return arregloVentas[posicion];

        return arregloVentas[posicion] + ventasMensuales(arregloVentas , posicion +1);
    }

    public static void main(String[] args) {
        //Selectiva - Repetitiva - Arreglos y Cadenas
        Scanner sc = new Scanner(System.in);

        String[] arregloNombres = { "Bryan" , "Jorge" , "Pedro" , "Aurelio" }; // 13 personas
        int[] arregloVentas = new int[arregloNombres.length];

        //CREANDO ARREGLOS DE BENEFICIOS
        String [] arregloBeneficios = { "50 soles" , "80 soles" , "120 soles" , "200 soles" , "Viaje a Máncora" };

        //ARREGLO DE MESES y Dias de los Meses
        String[] arregloMeses = {"Enero" , "Febrero" , "Marzo" , "Abril" , "Mayo" , "Junio" , "Julio" , "Agosto" ,
                "Setiembre" , "Octubre" , "Noviembre" , "Diciembre"};
        int[] arregloDiasMeses = {31 , 28 , 31 ,30 ,31, 30 ,31 ,31 ,30 ,31 ,30 ,31 };


        //Esto Grafica los 30 días Calendarios y SE REPITEN POR CADA MES DE TODO EL AÑO
        //DÍA VIENE A SER LA VARIBLE "i" y REPRESENTA EL MES QUE SE USARÁ
        for(int dia=0 ; dia<= arregloMeses.length - 1 ; dia++){
            System.out.println("Mes de " + arregloMeses[dia]);
            int dias = arregloDiasMeses[dia]; //DÍAS SE REFIERE A LOS DÍAS QUE TIENE EL MES USADO
            int contador = 0;

            while(contador<=dias-1){
                for(int d= 1; d<= dias ; d++){
                    contador = contador + 1;
                    System.out.println("Ventas del Día " + d );

                    //Ingresando los pedidos diarios que lleva cada Vendedor
                    for(int i=0 ; i<=arregloNombres.length-1 ; i++){
                        System.out.println("Ingrese las ventas del día " + d +" de " + arregloNombres[i] + " :");
                        int ventas = sc.nextInt();
                        arregloVentas[i] = arregloVentas[i]+ventas;
                    }

                    if(d==arregloDiasMeses[dia]){
                        System.out.println();
                        //Lista de Vendedores Ordenados desde el Top hasta el Menos Top
                        System.out.println("La lista Top de vendedores fueron: ");
                        ordenamientoPorVentas(arregloNombres , arregloVentas);
                        imprimir(arregloNombres , arregloVentas);
                    }
                }
                //LISTA DE VENDEDORES QUE LLEVARON PREMIOS
                System.out.println();
                listaGanadores(arregloNombres , arregloVentas);
                System.out.println();

                //VENTAS MENSUALES DE LA EMPRESA
                int ventasMensualesTotales = ventasMensuales(arregloVentas , 0);
                System.out.println("Las ventas mensuales qu tuvo Artika son: "+ ventasMensualesTotales + " helados");

                System.out.println("*******************************************************");
                System.out.println("*******************************************************");

            }

        }

    }
}

