package Learn.b1;

public class Easy {
    private boolean check = true;
    public synchronized void odd(int num){
        while(!check){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(num + " Hello world");
        check = false;
        notify();
    }

    public synchronized void even(int num){
        while(check){
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(num + " Hello world");
        check = true;
        notify();
    }
}
