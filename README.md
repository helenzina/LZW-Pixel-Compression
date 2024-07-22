<div align="center">
<img src="https://www.orpalis.com/wp-content/uploads/2013/04/lzw_compression.jpg"/>
<h3 align="center">LZW Pixel Compression-Decompression</h3>
<p align="center">
Using Java
<br/>
<br/>
<a href="https://github.com/helenzina/LZW-Pixel-Compression"><strong>Explore the docs</strong></a>
</p>
</div>

 ### Built With

This project was built with the following:
- <a href="https://www.java.com/en/">Java</a>.
- <a href="https://www.jetbrains.com/idea/download/?section=windows">IntelliJ Community IDEA</a> for the IDE.

 ## About The Project
 
<p align="center">
<img src="https://github.com/helenzina/LZW-Pixel-Compression/blob/main/run.gif"  title="run"/>
</p>

LZW compression is a method to reduce the size of Tag Image File Format (TIFF) or Graphics Interchange Format (GIF) files. It is a table-based lookup algorithm to remove duplicate data and compress an original file into a smaller file. LZW compression is also suitable for compressing text and PDF files. 

## How LZW Works
LZW compression works by reading a sequence of symbols, grouping the symbols into strings, and converting the strings into codes. Because the codes take up less space than the strings they replace, we get compression. Characteristic features of LZW includes, 

- LZW compression uses a code table, with 4096 as a common choice for the number of table entries. Codes 0-255 in the code table are always assigned to represent single bytes from the input file.
- When encoding begins the code table contains only the first 256 entries, with the remainder of the table being blanks. Compression is achieved by using codes 256 through 4095 to represent sequences of bytes.
- As the encoding continues, LZW identifies repeated sequences in the data and adds them to the code table.
- Decoding is achieved by taking each code from the compressed file and translating it through the code table to find what character or characters it represents. If a code can't be found, there's an **Early Code Emission Issue**, i.e. when a string is encountered for the first time, a new code is emitted before the corresponding string has been fully processed and added to the dictionary. During decompression, receiving a code that refers to an undefined dictionary entry (say x) causes issues. Then the decoder relies on the theory that if the two previous strings in a row (which are already decompressed) are the same, then the next string will be the same as these.

## Getting Started
 
 ### Installation
 
<p>Please follow the following steps for successful installation:</p>

1. Install <a href="https://www.jetbrains.com/idea/download/?section=windows">IntelliJ Community IDEA</a>. 
   
2. Clone the repo
   ```sh
   gh repo clone helenzina/LZW-Pixel-Compression
   ```
3. There's also an .exe application available to run it instantly without using any IDE at the next section. 

## How To Run

### Using IntelliJ Community IDEA

To run LZW Compression, follow these steps:

**Open the folder of your local repository in IntelliJ Community IDEA, select jdk-21 for the compiler and run it**. 

### Using .exe

To run LZW Compression, follow these steps:

1. <b>Download the .exe application (<a href="https://github.com/helenzina/LZW-Pixel-Compression/blob/main/out/artifacts/LZWcomp_jar/LZWcomp-x86_64.exe 
">LZWcomp-x86_64.exe</a>)</b>.

2. **Open a command prompt and navigate into the folder the .exe is installed**. For example:
   ```sh
   cd C:\Users\Helen\Desktop
   ```
3. **Run the .exe application by entering its name**.
   ```sh
   LZWcomp-x86_64.exe
   ```

## Troubleshooting

This project was compiled using JDK 21. If it doesn't run, place the folder <a href="https://drive.google.com/open?id=1dET8y46h3MsdtlYhXiMdfxxt5jR14l5L&usp=drive_fs">jdk-21</a> into the Java's folder:
   ```sh
   C:\Program Files\Java
   ```

 ## Usage

Here are some examples of the algorithm running:

<table>
  <tr>
    <td>
    Normal example - Finding all codes
     <img src="https://github.com/helenzina/LZW-Pixel-Compression/blob/main/normal.png" />
    </td>
    <td>
    Hard example - Occuring higher value code (Early Code Emission)
     <img src="https://github.com/helenzina/LZW-Pixel-Compression/blob/main/hard.png" />
    </td>
</tr>
</table>

 
## Collaborators

<p>This project was developed individually for the "Digital Image Processing" course at International Hellenic University.</p>
<table>
<tr>

<td align="center">
<a href="https://github.com/helenzina">
<img src="https://avatars.githubusercontent.com/u/128386591?v=4" width="100px" alt="Helen Zina"/><br>
<sub>
<b>Helen Zina (Me)</b>
</sub>
</a>
</td>

</tr>
</table>

 ## License

Distributed under the MIT License. See the LICENSE file for more information.

 ## Contact
 
If you have any questions or suggestions, feel free to reach out to me:
- Helen Zina - helenz1@windowslive.com
- Project Link: https://github.com/helenzina/LZW-Pixel-Compression

 ## Acknowledgments

The resources that helped me through this whole process were the following:

- [GeeksForGeeks](https://www.geeksforgeeks.org/lzw-lempel-ziv-welch-compression-technique/)

