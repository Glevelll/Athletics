import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

public class Athlete {
    protected String name;
    protected String surname;
    protected String subject;
    protected LocalDate birthDate;
    protected char gender;
    protected double result;
    public static boolean h;

    Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void SetName(String name) {this.name = name;}

    public String getSurname() {
        return surname;
    }

    public void SetSurname(String surname) {
        this.surname = surname;
    }

    public String getSubject() {
        return subject;
    }

    public void SetSubject(String subject) {this.subject = subject;}

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void SetBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void SetGender(char gender) {
        if((gender == 'м') || (gender == 'ж')){
            this.gender = gender;
        } else{
            System.out.println("Неверно введён пол");
        }

    }

    public Athlete(String subject) {
        this.subject = subject;
    }

    public static Athlete register() {
        Scanner sc = new Scanner(System.in);
        Athlete athlete = new Athlete("Татарстан");
        System.out.print("Имя спортсмена: ");
        athlete.name = sc.next();
        System.out.print("Фамилия спортсмена: ");
        athlete.surname = sc.next();
        System.out.print("Дата рождения (гггг-мм-дд): ");
        athlete.birthDate = LocalDate.parse(sc.next());
        System.out.print("Пол спортсмена (м/ж): ");
        athlete.gender = sc.next().charAt(0);
        System.out.println(athlete.toString());
        return athlete;
    }

    @Override
    public String toString() {
        return "Спортсмен: " + name + " " + surname
                + "; Дата рождения: " + birthDate +
                "; Возраст: " + Period.between(birthDate, LocalDate.now()).getYears() +
                "; Субъект: " + subject + "; Пол: " + gender;
    }

    protected void Vid(Form sport){
        System.out.println("Результат в виде " + sport.getName() + "?");
        result = sc.nextDouble();

        if (sport instanceof Short_distance) {
            ShortDist(sport);
        }

        else if (sport instanceof Long_distance) {
            LongDist(sport);
        }

        else if (sport instanceof Long_jump) {
            LongJump(sport);
        }
        else if (sport instanceof High_jump) {
            HighJump(sport);
        }
    }

    private void ShortDist(Form sport){
        if (!(((Short_distance) sport).DQ(rand)) && (gender == 'м') && (result <= 21.30)) {
            h = true;
            System.out.println("Результат удовлетворителен");
        }
        else if (!(((Short_distance) sport).DQ(rand)) && (gender == 'ж') && (result <= 24.30)) {
            h = true;
            System.out.println("Результат удовлетворителен");
        }
            else if (((Short_distance) sport).DQ(rand)) {
                h = false;
            System.out.println("Дисквалификация!");
        } else if ((gender == 'м') &&(result > 21.30)){
            h = false;
            System.out.println("Результат неудволетворителен");
        }
        else if ((gender == 'ж') &&(result > 24.30)){
            h = false;
            System.out.println("Результат неудволетворителен");
        }
    }

    private void LongDist(Form sport){
        if (!(((Long_distance) sport).DQ(rand)) && (gender == 'м') && (result <= 14.00)) {
            h = true;
            System.out.println("Результат удовлетворителен");
        }
        else if (!(((Long_distance) sport).DQ(rand)) && (gender == 'ж') && (result <= 16.30)) {
            h = true;
            System.out.println("Результат удовлетворителен");
        }
            else if (((Long_distance) sport).DQ(rand)) {
            h = false;
                System.out.println("Дисквалификация!");
        } else if ((gender == 'м') && (result > 14.00)){ h = false;
            System.out.println("Результат неудволетворителен");
            }
        else if ((gender == 'ж') &&(result > 16.30)){
            h = false;
            System.out.println("Результат неудволетворителен");
        }
    }

    private void LongJump(Form sport){
        if (!(((Long_jump) sport).DQ(rand)) && (gender == 'м') && (result >= 7.60)) {
            h = true;
            System.out.println("Результат удовлетворителен");
        }
        else if (!(((Long_jump) sport).DQ(rand)) && (gender == 'ж') && (result >= 6.30)) {
            h = true;
            System.out.println("Результат удовлетворителен");
        }
        else if (((Long_jump) sport).DQ(rand)) {
            h = false;
            System.out.println("Дисквалификация!");
        } else if ((gender == 'м') && (result < 7.60)) {
            h = false;
            System.out.println("Результат неудволетворителен");
        }
        else if ((gender == 'ж') &&(result < 6.30)){
            h = false;
            System.out.println("Результат неудволетворителен");
        }
    }

    private void HighJump(Form sport){
        if (!(((High_jump) sport).DQ(rand)) && (gender == 'м')  && (result >= 2.15)) {
            h = true;
            System.out.println("Результат удовлетворителен");
        }
        else if (!(((High_jump) sport).DQ(rand)) && (gender == 'ж') && (result >= 1.90)) {
            h = true;
            System.out.println("Результат удовлетворителен");
        }
        else if (((High_jump) sport).DQ(rand)) {
            h = false;
            System.out.println("Дисквалификация!");
        } else if ((gender == 'м') && (result < 2.15)) {
            h = false;
            System.out.println("Результат неудволетворителен");
        }
        else if ((gender == 'ж') &&(result < 1.90)){
            h = false;
            System.out.println("Результат неудволетворителен");
        }
    }

    public void output() {
            System.out.println("Фамилия: " + surname);
            System.out.println("Имя: " + name);
            System.out.println("Дата: " + birthDate);
            System.out.println("Пол: " + gender);
            System.out.println("Возраст: " + Period.between(birthDate, LocalDate.now()).getYears());
            System.out.println("Субъект: " + subject);
            if(h == true){
                System.out.println("Статус: допущен");
            }
            else if (h == false){
                System.out.println("Статус: не допущен");
            }
    }

}