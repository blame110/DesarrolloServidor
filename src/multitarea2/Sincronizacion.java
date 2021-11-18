package multitarea2;

//Uso de Sincronizacion para controlar el acceso.
class sumArray{
    private int sum;

    //sumArray está sincronizado
    synchronized int sumArray(int nums[]){
        sum=0;
        for (int i=0; i<nums.length;i++){
            sum=sum +nums[i];
            System.out.println("Total acumulado de "+Thread.currentThread().getName()+" es "+sum);
        try {
            Thread.sleep(10);//permitir el cambio de tarea
        }catch (InterruptedException exc){
            System.out.println("Hilo interrumpido");
        }
        }
        return sum;
    }
}

class MiHilo implements Runnable{
    Thread hilo;
    static sumArray sumarray= new sumArray();
    int a[];
    int resp;

    //Construye un nuevo hilo.
    MiHilo(String nombre, int nums[]){
        hilo= new Thread(this,nombre);
        a=nums;
    }

    //Un método que crea e inicia un hilo
    public static MiHilo creaEInicia (String nombre,int nums[]){
        MiHilo miHilo=new MiHilo(nombre,nums);

        miHilo.hilo.start(); //Inicia el hilo
        return miHilo;
    }
    //Punto de entrada del hilo
    public void run(){
        int sum;
        System.out.println(hilo.getName()+ " iniciando.");

        resp=sumarray.sumArray(a);
        System.out.println("Suma para "+hilo.getName()+ " es "+resp);
        System.out.println(hilo.getName()+ " terminado.");
    }
}
class Sincronizacion {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        MiHilo mh1 = MiHilo.creaEInicia("#1",a);
        MiHilo mh2 = MiHilo.creaEInicia("#2",a);

        try {
            mh1.hilo.join();
            mh2.hilo.join();
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
    }
}