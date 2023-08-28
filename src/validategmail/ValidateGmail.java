
package validategmail;
import javax.swing.*;
public class ValidateGmail {

    public static void main(String[] args) {
		
        String gmailAddress = JOptionPane.showInputDialog("Enter your Gmail address (example@gmail.com)");

        boolean lengthvalidate = checkLength(gmailAddress);
        boolean specValidate = checkSpecial(gmailAddress);
        boolean gmailValidate = checkgmail(gmailAddress);


        while(lengthvalidate != true || specValidate != true || gmailValidate != true){

                if(lengthvalidate == false){

                    JOptionPane.showMessageDialog(null, "Username must be between 6 - 30 Characters", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if(specValidate == false){

                    JOptionPane.showMessageDialog(null, "Username must include @ as a special character", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if(gmailValidate == false){


                    JOptionPane.showMessageDialog(null, "Username must include domain type (gmail.com)", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                
                gmailAddress = JOptionPane.showInputDialog("Re-Enter your Gmail address (example@gmail.com)");

                lengthvalidate = checkLength(gmailAddress);
                specValidate = checkSpecial(gmailAddress);
                gmailValidate = checkgmail(gmailAddress);

        }

        if(lengthvalidate == true && specValidate == true && gmailValidate == true){

            JOptionPane.showMessageDialog(null, "Successfully validated", "VALIDATED", JOptionPane.WARNING_MESSAGE);
        }
    }

    //sifisom380@gmail.com

    public static boolean checkLength(String gmailAddress){

        int len = gmailAddress.length();

        boolean resultsLength = false;

        if(len >=6 && len <= 30){

                resultsLength = true;
        }
        else{
                resultsLength = true;
        }

        return resultsLength;

    }

    public static boolean checkSpecial(String gmailAddress){
        int countsopeciFoun = 0;

        int len = gmailAddress.length();

        boolean specialCha = false;

        for(int x = 0; x < len; x++){

                Character check = gmailAddress.charAt(x);
                Character at = '@';

                if(check.equals(at)){
                        countsopeciFoun++;
                }
        }

                if(countsopeciFoun == 1) {
                        specialCha = true;
                }
                else{
                        specialCha = false;
                }

        return specialCha;
    }

    public static boolean checkgmail(String gmailAddress){

        boolean geemailCheck = false;
        int len = gmailAddress.length();
        int indx = gmailAddress.indexOf('@') + 1;

        String finduntilspec = gmailAddress.substring(0, indx); 

        String remaining = gmailAddress.substring(indx,len); 

        if(remaining.equals("gmail.com")){

                geemailCheck = true;
        }
        else {
                geemailCheck = false;
        }

        return geemailCheck;
    }
}
