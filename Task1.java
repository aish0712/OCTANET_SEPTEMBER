import java.util.*;
public class Task1{

    public static int withdrawl(int bal, int amt){

        if(amt>bal){
            return -1;
        }

        else{
            int newAmt=bal-amt; 
            return newAmt;


        }


    }

    public static int deposit(int bal, int dep){

        int newAmt=dep+bal; 
        return newAmt;


    }

    public static int transfer(int bal, int trans){

        if(trans>bal){
            return -1;
        }
        else{
            int newAmt=bal-trans;
            return(newAmt);
        }
        

    }


    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        //ACCOUNT DETAILS
        HashMap<Integer, Integer> accDetails= new HashMap<>();

        accDetails.put(12345,2233);
        accDetails.put(67890,9988);
                

        //ACCOUNT BALANCE
        HashMap<Integer, Integer> accBalance=new HashMap<>();

        accBalance.put(12345,10000);
        accBalance.put(67890,10000);
        

        //TRANSACTION HISTORY
        HashMap<String, Integer> transacHistory1= new HashMap<>();
        HashMap<String, Integer> transacHistory2= new HashMap<>();

        


        int t=1;
        int count=0;

        while(t==1){
            System.out.print("Enter 5-digit account number: ");
            int acc=sc.nextInt();

            

            if(accDetails.containsKey(acc)){
                System.out.println("Enter 4-digit pin: ");
                int pin=sc.nextInt();
                count++;
                
                if(pin==accDetails.get(acc)){

                    System.out.println("WELCOME!");
                    System.out.println("What would You like to do?");
                    System.out.println("1. CHECK TRASACTION HISTORY");
                    System.out.println("2. CASH WITHDRAWL");
                    System.out.println("3. CASH DEPOSIT");
                    System.out.println("4. MONEY TRANSFER");
                    System.out.println("5. QUIT");

                    System.out.print("Enter Your Choice(1 to 5): ");

                    int choice=sc.nextInt();

                    if(choice==1){

                        if(acc==12345){
                            if(transacHistory1.size()==0){
                                System.out.println("No history!");
                            }
                            else{
                                for(Map.Entry<String, Integer> entry: transacHistory1.entrySet()){
                                    System.out.println(entry.getKey()+" : "+entry.getValue());
                                }
                            }
                        }

                        else{
                            if(transacHistory2.size()==0){
                                System.out.println("No history!");
                            }
                            else{
                                for(Map.Entry<String, Integer> entry: transacHistory2.entrySet()){
                                    System.out.println(entry.getKey()+" : "+entry.getValue());
                                }
                            }
                            
                        }

                        System.out.println("Press 1 to continue or anyother number to exit: "); 
                        t=sc.nextInt();
                        
                    }

                    else if(choice==2){

                        System.out.println("Enter the Amount: ");
                        int amt=sc.nextInt();

                        int res2=withdrawl(accBalance.get(acc),amt); 
                        if (res2==(-1)){
                            System.out.println("Insufficient Amount!");
                        }

                        else{

                            System.out.println("Withdrwal SuccessFull! Account Balance: "+res2);
                            if(acc==12345){
                                
                                accBalance.replace(12345,res2);
                                transacHistory1.put("Withdrwal",res2);
                            }

                            else{

                                accBalance.replace(67890,res2);
                                transacHistory2.put("Withdrwal",res2);
            
                            }

                        }

                        System.out.println("Press 1 to continue or anyother number to exit: "); 
                        t=sc.nextInt();

                    }

                    else if(choice==3){

                        System.out.println("Enter the Deposit: ");
                        int dep=sc.nextInt();
                        int res3=deposit(accBalance.get(acc),dep);

                        System.out.println("Deposit Successfull! Account balance: "+res3);
                        if(acc==12345){
                                
                                accBalance.replace(12345,res3);
                                transacHistory1.put("Deposit",res3);
                            }

                            else{

                                accBalance.replace(67890,res3);
                                transacHistory2.put("Deposit",res3);
            
                            }

                        System.out.println("Press 1 to continue or anyother number to exit: "); 
                        t=sc.nextInt();

                    }

                    else if(choice==4){

                        System.out.println("Enter amount to Transfer: ");
                        int trans=sc.nextInt();
                        System.out.println("Enter destination Account: ");
                        int destAcc=sc.nextInt();
                        int res4=transfer(accBalance.get(acc),trans);

                        if(res4==-1){
                            System.out.println("Insufficient Amount!Try again");
                        }
                        else{
                            System.out.println("Transfer Successful! Account Balance: "+res4);
                            if(acc==12345){
                                
                                accBalance.replace(12345,res4);
                                transacHistory1.put("Transfer to "+destAcc ,res4);
                            }

                            else{

                                accBalance.replace(67890,res4);
                                transacHistory2.put("Transfer to "+destAcc,res4);
            
                            }

                        }

                        System.out.println("Press 1 to continue or anyother number to exit: "); 
                        t=sc.nextInt();

                    }

                    else{
                        t=0;
                    }

                }

                else{
                    System.out.println("Invalid pin! Try again");
                    if(count==3){
                        System.out.println("Account blocked!");
                        break;
                    }
                }
            }

            else{
                System.out.println("Invalid account number! Try again");
            }

        }

        System.out.println("THANK YOU!");

        sc.close();

    }


}