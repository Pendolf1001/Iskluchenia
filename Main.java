import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Attestacia
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String [] info=new String [6] ;
        System.out.println("F I O dd.mm.yyyy tel pol");
        String vvod=sc.nextLine();
        try{
            info=vvod.split(" ");
            if (info.length>6){
                throw new RuntimeException("vvedeny lishnie dannie");
            }
            String familia=info[0];
            if (familia.matches("(.*)[0-9](.*)+")){
                throw new RuntimeException("nepravilniy vvod familii");
            }
            String imya=info[1];
            if (imya.matches("(.*)[0-9](.*)+")){
                throw new RuntimeException("nepravilniy vvod imeni");
            }
            String otchestvo=info[2];
            if (otchestvo.matches("(.*)[0-9](.*)+")){
                throw new RuntimeException("nepravilniy vvod otchectva");
            }
            int tel= Integer.parseInt(info[4]);

            String pol=info[5];
            if (!pol.equals("f")&&(!pol.equals("m"))){
                throw new RuntimeException("nepravilno vveden pol (dopustimy znacheniya \" m\"  i \"f\" )");
            }
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate bd=LocalDate.parse(info[3], formatter);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Vvedeno nedostatochnoe kol-vo elementov");
            return;
        } catch (NumberFormatException e){
            System.out.println("Neverno vveden nomer telefona");
            return;
        }
        catch (java.time.format.DateTimeParseException e) {
            System.out.println("Neverniy format daty rozhdeniya");
            return;
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            return;
        }
        String fName= familia +".txt";
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fName))) {
			for (String value : info) {
				writter.write(value + " ");
				}
			writter.write("\n");

		}catch (IOException e) {
			e.printStackTrace();
		}
    }
}