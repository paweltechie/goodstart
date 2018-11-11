import java.util.*;

public class Processes {
    public static void main(String args[]) {
        Processes myApp = new Processes();
        myApp.orderProcesses();
    }

    public void orderProcesses() {

        String[] test = {"(0,1)", "(1,2)", "(2,3)", "(2,4)", "(4,3)"};
        ArrayList<String> processes = new ArrayList<String>(Arrays.asList(test));

        ArrayDeque<String> result = new ArrayDeque<>();
        while (result.size() < processes.size()) {
            String dependant = test[0].substring(test[0].length() - 2, test[0].length() - 1);
            String process = String.valueOf(test[0].charAt(1));
            String process2, dependant2;
            int node = 0;
            for (int i = 1; i < test.length; i++) {
                process2 = String.valueOf(test[i].charAt(1));
                dependant2 = test[i].substring(test[i].length() - 2, test[i].length() - 1);
                if (process2.equals(dependant)) {
                    dependant = dependant2;
                    process = process2;
                    node = i;
                }
            }
            result.add(dependant);
            processes.remove(node);
            for (int i = 0; i < processes.size(); i++) {
                process2 = String.valueOf(processes.get(i).charAt(1));
                dependant2 = processes.get(i).substring(processes.get(i).length() - 2, processes.get(i).length() - 1);
                if (dependant2.equals(process)) {
                    result.add(process2);
                }
            }
        }
        while (result.size() > 0)
            System.out.print(result.pop());
    }
}
