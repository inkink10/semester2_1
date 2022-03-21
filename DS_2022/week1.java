import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mainjava {
    int[] arr = new int[20];
    int size = arr.length;

    public static void main(String[] args) throws IOException {
        Mainjava mainjava = new Mainjava();

        File file = new File("C:\\Users\\inkin\\IdeaProjects\\semester2_1\\src\\input.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(fileReader);
        String line =  "";
        List<String> list = new ArrayList<>();
        while((line = bufReader.readLine())!=null){
            list.add(line);
        }

        mainjava.insert(list.get(0));

        if(list.size()>1){
            for(int i=1;i<list.size();i++){
                String one = list.get(i);
                String [] split = one.split(" ");
                int index = Integer.parseInt(split[0]);
                int plus = Integer.parseInt(split[1]);

                mainjava.modify(index,plus);
            }
            System.out.println("\n1-2의 출력");
            mainjava.print();
        }


    }
    public void insert(String x){

        String [] split = x.split(" ");

        int size1 = split.length;
        for(int i=0;i<size1;i++){
            int a = Integer.parseInt(split[i]);
            arr[i] = a;
        }

        for(int i=1;i<size1;i++){
            int j = i-1;
            int standard = arr[i];
            while(j>=0 && standard<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=standard;
        }

        size = size1;
        System.out.println("1-1의 출력");
        print();
    }
    public void modify(int a, int b){
        arr[a] += b;

        for(int i=1;i<size;i++){
            int j = i-1;
            int standard = arr[i];
            while(j>=0 && standard<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=standard;
        }
    }

    public void print(){

        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
    }
}
