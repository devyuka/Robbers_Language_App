public class Driver {
    public static void main(String[] args) {
        RobbersLanguage test = new RobbersLanguage();
        System.out.println(test.replaceLetters("joy"));
        System.out.println(test.replaceLetters("ham"));
        System.out.println(test.replaceLetters("aieou"));
    }
}