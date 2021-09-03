package com.example.spring2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanos {

    public int [] valores = {4000,1000,500,100,50,10, 5, 1};
    public String [] letras = {"Mv","M","D","C","L","X", "V", "I"};


    @GetMapping("convNumbers1/{number}")
    public int roman1(@PathVariable String roman) {
        int decimal = 0;

        String romanNumeral = roman;
        for(int x = 0;x<romanNumeral.length();x++)
        {
            char convertToDecimal = roman.charAt(x);

            switch (convertToDecimal)
            {
                case 'M':
                    decimal += 1000;
                    break;

                case 'D':
                    decimal += 500;
                    break;

                case 'C':
                    decimal += 100;
                    break;

                case 'L':
                    decimal += 50;
                    break;

                case 'X':
                    decimal += 10;
                    break;

                case 'V':
                    decimal += 5;
                    break;

                case 'I':
                    decimal += 1;
                    break;
            }
        }
        if (romanNumeral.contains("IV"))
        {
            decimal-=2;
        }
        if (romanNumeral.contains("IX"))
        {
            decimal-=2;
        }
        if (romanNumeral.contains("XL"))
        {
            decimal-=10;
        }
        if (romanNumeral.contains("XC"))
        {
            decimal-=10;
        }
        if (romanNumeral.contains("CD"))
        {
            decimal-=100;
        }
        if (romanNumeral.contains("CM"))
        {
            decimal-=100;
        }
        return decimal;
    }




    //Exemplo de chamada -> http://localhost:8080/convNumbers/23
    @GetMapping("convNumbers/{number}")
    public String roman(@PathVariable int number){
        String romano="";
        String retorno="";
        if(number<4000) {
            for (int i = 0; i < valores.length; i++) {
                while (number >= valores[i]) {
                    number -= valores[i];
                    romano += letras[i];
                }
            }

            romano = romano.replace("IIII","IV");
            romano = romano.replace("VIIII","IX" );
            romano = romano.replace("XXXX","XL");
            romano = romano.replace("LXXXX","XC");
            romano = romano.replace("CCCC","CD" );
            romano = romano.replace("DCCCC","CM" );



            retorno = romano;
        }else{
                    romano = "So mostramos ate 4999";
                    retorno = romano;
        }
        return retorno;
    }

    //Exemplo de chamada -> http://localhost:8080/convNumbers?number=23
    @GetMapping("convNumbers")
    public String roman01(@RequestParam int number){
        String romano="";
        for(int i=0; i<valores.length;i++){
            while(number>=valores[i]){
                number-=valores[i];
                romano+=letras[i];
            }
        }
        return romano;
    }


}
