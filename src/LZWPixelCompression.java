/**
    @author Helen Zina
**/


import java.util.*;

public class LZWPixelCompression {

    public static List<Integer> compressPixelData(List<Integer> pixelData) {
        Map<String, Integer> dictionary = new HashMap<>();//dictionary- str code
        for (int i = 0; i < 256; i++) {
            dictionary.put(String.valueOf(i), i);//gemizw 0-255
        }

        List<Integer> compressedData = new ArrayList<>();
        String str = "";
        for (Integer next : pixelData) {
            String newStr = str + next;
            if (dictionary.containsKey(newStr)) {//yparxei str - antikatastash
                str = newStr;
            } else {
                compressedData.add(dictionary.get(str));//out
                dictionary.put(newStr, dictionary.size());//neo str sto dictionary
                str = "" + next;//next->str
            }
        }

        if (!str.equals("")) { //eof - teleytaio str->out
            compressedData.add(dictionary.get(str));
        }

        return compressedData;
    }

    public static List<Integer> decompressPixelData(List<Integer> compressedData) {
        Map<Integer, String> dictionary = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dictionary.put(i, "" + (char) i);//ascii
        }

        List<Integer> decompressedData = new ArrayList<>();
        int firstStr = compressedData.get(0);
        String str = "" + (char) firstStr;//ascii
        decompressedData.add(firstStr);
        int count = 256;
        for (int i = 1; i < compressedData.size(); i++) {
            Integer newCode = compressedData.get(i); //next->str
            String newData;

            if (dictionary.containsKey(newCode)) { //yparxei code ara pairnei str
                newData = dictionary.get(newCode);
            } else if (newCode == count) { //periptwsh enanalhpsimothtas - briskei to code
                newData = str + str.charAt(0);
            } else {
                throw new IllegalArgumentException("Invalid compressed data");
            }

            dictionary.put(count++, str + newData.charAt(0)); //new code|str
            for (char c : newData.toCharArray()) {
                decompressedData.add((int) c); //gia kathe char->ascii value
            }
            str = newData; //updating out/data
        }

        return decompressedData;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> pixelData = new ArrayList<>();
        System.out.println("Enter pixels values (separate each value by space):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        for (String value : values) {
            pixelData.add(Integer.parseInt(value));
        }

        //List<Integer> pixelData = Arrays.asList(10, 20, 10, 20, 25, 20, 25, 20, 10, 20, 20, 10, 20, 10, 10, 20); //pixel data
        //List<Integer> pixelData = Arrays.asList(10, 20, 10, 10, 10, 20, 10, 10); //pixel data
        //List<Integer> pixelData = Arrays.asList(10, 10, 30, 30, 10, 10, 30, 30, 10, 10, 30, 30, 10, 10, 30, 30); //pixel data
        //List<Integer> compressedData = compressPixelData(pixelData);
        List<Integer> compressedData = pixelData;
        System.out.println("Compressed Data: " + compressedData);

        List<Integer> decompressedData = decompressPixelData(compressedData);
        System.out.println("Decompressed Data: " + decompressedData);
    }
}
