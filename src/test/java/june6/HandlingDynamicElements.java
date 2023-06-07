package june6;

public class HandlingDynamicElements {


    public static void main(String[] args) {


        // Dynamic element -> element whose attribute changes with each page load


        //input[starts-with(@name, 'name')]
        //input[ends-with(@id, '_user')]
        //input[contains(@aria-label, 'color')]


//        How to handle dynamic elements in Selenium?

        // Use starts with, ends-with or contains methods of Xpath, or CSS

        //CSS equivalents

        //  input[name^='name']  -> starts-with
        // input[name$='name']   -> ends-with
        // input[name*='name']   -> contains

       // /html/body/center/form/div/table[2]/tbody/tr[32]/td[3]/input

    }
}
