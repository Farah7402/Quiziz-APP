package com.example.farahjabeen.wq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.farahjabeen.wq.QuizContract.*;


import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "WorldQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    private static QuizDbHelper instance;


    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized QuizDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDbHelper(context.getApplicationContext());

        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
                CategoriesTable.TABLE_NAME + "( " +
                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";

        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void fillCategoriesTable() {
        Category c1 = new Category("Science");
        addCategory(c1);
        Category c2 = new Category("Sports");
        addCategory(c2);
        Category c3 = new Category("Famous Places");
        addCategory(c3);
        Category c4 = new Category("Technology");
        addCategory(c4);
        Category c5 = new Category("General Knowledge");
        addCategory(c5);

    }

    private void addCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);
    }

    private void fillQuestionsTable() {

        //Science Easy
        Question q1 = new Question("Which is the biggest planet in our soloar system ",
                "Uranus", "Jupiter ", " Saturn", 2,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q1);

        Question q2 = new Question("Which of the follwoing is used in pencile?",
                "Graphite", "Silicon", "Charcoal", 1,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q2);

        Question q3 = new Question("Pure water has a pH level of a round",
                "7", "6", "9", 1,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q3);

        Question q4 = new Question("The fear of what animals is known as 'arachnophobia'",
                "Dogs", "Lizards", "Spiders", 3,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q4);

        Question q5 = new Question("How many bones do shark have in their bodies?",
                "0", "310", "213", 1,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q5);

        Question q6 = new Question("What is the name of part of human skeleton which protects our brain?",
                "Skin", "Skull", "No idea", 2,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q6);


        Question q7 = new Question("Is the compound HCI is an acid or base?",
                "Base", "Acid", "No One", 2,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q7);

        Question q8 = new Question("What is the chemical symbol for an elemnt oxygen? ",
                "Hi", "H2", "O", 3,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q8);

        Question q9 = new Question("What is the name of closet star to the earth?",
                "The Venus", "The Sun ", "The Mars", 2,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q9);

        Question q10 = new Question("What famous scientist was awarded the 1921 Nobel Prize in Physics for his work on theoratical physics?",
                "Galileo Galilei", "Albert Einstein", "No idea", 2,
                Question.DIFFICULTY_EASY, Category.SCIENCE);
        addQuestion(q10);

        //Science Mediusm

        Question q11 = new Question("Acid present in gastric juice is?",
                "Citric Acid", "Acetic Acid", "Hydrochloric Acid", 3,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q11);

        Question q12 = new Question("Which blood cells are called 'Soliders' of the body",
                "Platelets", "WBC", "Both", 2,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q12);

        Question q13 = new Question("Which color of light is deviated least",
                "Blue", "Green", "Red", 3,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q13);

        Question q14 = new Question("Which of the following is not a primary color?",
                "Red", "Yellow", "No one", 2,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q14);

        Question q15 = new Question("The S.I unit of refractive index is",
                " cm", "watt", "None", 3,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q15);

        Question q16 = new Question("Last Solar eclipse accurred in Pakistan on?",
                "14th August 2017", "12 August 2017", "21st August 2017", 3,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q16);

        Question q17 = new Question("weight of earth is?",
                "6586 * 1018 tons", " 6589 * 1019 tons", "6588 * 1018 tons", 1,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q17);

        Question q18 = new Question("Smallest continent of the world is?",
                "Europe ", "Australia", "South America", 2,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q18);

        Question q19 = new Question("When the earth comes between Moon and Sun and Sun light is unable to reach on moon this type of solar eclipse is known as?",
                "Solar Eclipse", "Partial Lunar Eclipse", "Lunar Eclipse", 3,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q19);

        Question q20 = new Question("Sister Dr Ruth Katherina Martha Pfau actually belong to which country?",
                "Russia", "Germany", "Canada", 2,
                Question.DIFFICULTY_MEDIUM, Category.SCIENCE);
        addQuestion(q20);

        //Science Difficult

        Question q21 = new Question("Which animal never drink water in entire life?",
                "Rat", "Hippopotamus", "Kangroo Rat", 3,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q21);

        Question q22 = new Question("The Largest cell is?",
                "Ovum", "The egg of an Ostrich", "Nerve Cell", 2,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q22);

        Question q23 = new Question("Which is the largest human cell",
                "Skin", "Liver", "Ovum", 3,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q23);

        Question q24 = new Question("How many dwarf planets in the solar system",
                "2", "3", "5", 2,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q24);

        Question q25 = new Question("When you leave wine exposed to the air, the etanol in it reacts with oxygen to form what?",
                " Ethanoic acid", "Ethyl acetate", "Both", 1,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q25);

        Question q26 = new Question("How does it take for the caffine in coffe to fully kick in?",
                "10 minutes", "An hour", "20 minutes", 3,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q26);

        Question q27 = new Question("Which food has more calcium per gram",
                "Kale", " Whole milk", "Both", 1,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q27);

        Question q28 = new Question("Is that true of false that we use only 10% of our brain?",
                " True", "False", "No Idea", 2,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q28);

        Question q29 = new Question("How many atoms are in a mole?",
                "6.002 * 10 ^ 21", "6.022 * 10 ^ 22", "6.022 * 10 ^ 23", 3,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q29);

        Question q30 = new Question("About how old is Earth?",
                "4.0 billion years old", "4.5 billion years old", "4 billion years old", 2,
                Question.DIFFICULTY_HARD, Category.SCIENCE);
        addQuestion(q30);

        //easy support
        Question q31 = new Question("Track and field Carl Lewis won how many gold medas at the 1984 Olymphic games?",
                "2", "8", "4", 3,
                Question.DIFFICULTY_EASY, Category.Sport);
        addQuestion(q31);

        Question q32 = new Question("Sultan Azlan Shah Cup is related to which among the following Sports?",
                "Badminton", "Hockey", "Table Tennis", 2,
                Question.DIFFICULTY_EASY, Category.Sport);
        addQuestion(q32);

        Question q33 = new Question("The word 'Agriculture Shot' is known to be used sometimes in which among the following sports? ",
                "Cricket", "Hockey", "Polo", 1,
                Question.DIFFICULTY_EASY, Category.Sport);
        addQuestion(q33);

        Question q34 = new Question("Which among the following is played on a synthetic hard court?",
                "Wimbledon", " US open", "Australia open", 3,
                Question.DIFFICULTY_EASY, Category.Sport);
        addQuestion(q34);

        Question q35 = new Question("Murugappa Gold Cup is related to which among the following sports?",
                " Football", " Hockey", "Cricket", 2,
                Question.DIFFICULTY_EASY, Category.Sport);
        addQuestion(q35);

        Question q36 = new Question("With which among the following sports, Ian Thorpe is related to?",
                "    Athletics", "Boxing", "Swimming", 3,
                Question.DIFFICULTY_EASY, Category.Sport);
        addQuestion(q36);

        Question q37 = new Question("Which of the following trophies is related with the game of ‘Football’?",
                "Everest Cup ", "Merdeka Cup ", "V.C.C. Cup", 2,
                Question.DIFFICULTY_EASY, Category.Sport);
        addQuestion(q37);

        Question q38 = new Question("How many number of Red Balls are in Snooker? \n",
                "15", "10", "12", 1,
                Question.DIFFICULTY_EASY, Category.Sport);
        addQuestion(q38);

        Question q39 = new Question("Who among the following is the first Indian to score a century in Indian Premier League (IPL)?",
                "Gautam Gambhir", "Manish Pandey", "Sachin", 2,
                Question.DIFFICULTY_EASY, Category.Sport);
        addQuestion(q39);

        Question q40 = new Question("The terms “Technical foul” and “Flagrant Foul” are most commonly associated with which of the following sports?",
                "Table Tennis", "Badminton", "Basket Ball", 3,
                Question.DIFFICULTY_EASY, Category.Sport);
        addQuestion(q40);

        // hard Sports

        Question q41 = new Question("Which country had started Football World?",
                "West Germany", "Italy", "Uruguay", 3,
                Question.DIFFICULTY_MEDIUM, Category.Sport);
        addQuestion(q41);

        Question q42 = new Question(" In which year Cricket world cup was first hosted by West Indies?",
                "1975", "1990", "2000", 1,
                Question.DIFFICULTY_MEDIUM, Category.Sport);
        addQuestion(q42);

        Question q43 = new Question("Asian Games have been hosted by _________for maximum number of times.",
                "Indians", "Thailand", "Pakistan", 2,
                Question.DIFFICULTY_MEDIUM, Category.Sport);
        addQuestion(q43);

        Question q44 = new Question("In which year Olympic Games were cancelled because of World War I?",
                "1916", "1917", "1918", 1,
                Question.DIFFICULTY_MEDIUM, Category.Sport);
        addQuestion(q44);

        Question q45 = new Question("___________ is used in Boxing.",
                "Bunder Chuckker", "Upper Cut", "Mallet", 2,
                Question.DIFFICULTY_MEDIUM, Category.Sport);
        addQuestion(q45);

        Question q46 = new Question("In which year Football World Cup was held in France?",
                "1998", "2000", "2018", 1,
                Question.DIFFICULTY_MEDIUM, Category.Sport);
        addQuestion(q46);

        Question q47 = new Question("Who was the winner of Football World Cup in 2010?",
                "Brazil", "Germany", "Spain", 3,
                Question.DIFFICULTY_MEDIUM, Category.Sport);
        addQuestion(q47);

        Question q48 = new Question("What is the Golden Slam?",
                "Super Slam plus Olympic gold", "Grand Slam plus Olympic gold", "Grand Slam plus Olympic silver", 2,
                Question.DIFFICULTY_MEDIUM, Category.Sport);
        addQuestion(q48);

        Question q49 = new Question("“National Football Museum” which keeps FIFA collection is located in which country?",
                "Canada", "Switzerland", "England", 3,
                Question.DIFFICULTY_MEDIUM, Category.Sport);
        addQuestion(q49);

        Question q50 = new Question("In which of the following sports/ games the term Interference is used?",
                "Table Tennis", "Squash", "Chess", 3,
                Question.DIFFICULTY_MEDIUM, Category.Sport);
        addQuestion(q50);

        //sports Hard

        Question q51 = new Question("Who is the only player in NBA history to win more than 7 championships in the same decade",
                "Bill Russell", "Michael Jordan", "No One", 1,
                Question.DIFFICULTY_HARD, Category.Sport);
        addQuestion(q51);
        Question q52 = new Question("Who has the longest College Football winning streak?",
                " USC", "UCLA", "Oklahoma", 3,
                Question.DIFFICULTY_HARD, Category.Sport);
        addQuestion(q52);
        Question q53 = new Question("Who is the only player in NFL history to return a kick for 109 Yards?",
                "Ed Reed", "Corradelle Patterson", "Desean Jackson", 2,
                Question.DIFFICULTY_HARD, Category.Sport);
        addQuestion(q53);
        Question q54 = new Question("Who is the first player in MLB history to win 3 consecutive batting titles",
                "Ted Williams", "Pete Rose", "Ty Cobb", 3,
                Question.DIFFICULTY_HARD, Category.Sport);
        addQuestion(q54);
        Question q55 = new Question("Which of the following footballers retired with fewer than 100 international cups ",
                "Francesco Totti", "Dirk Kuyt", "Xabi Alonso", 1,
                Question.DIFFICULTY_HARD, Category.Sport);
        addQuestion(q55);
        Question q56 = new Question("How many points did England score in the Rugby League World Cup final?",
                "1", "5", "None", 3,
                Question.DIFFICULTY_HARD, Category.Sport);
        addQuestion(q56);

        Question q57 = new Question("On which day of the week do the Spanish usually play football?",
                "Sunday", "Saturday", "Friday", 1,
                Question.DIFFICULTY_HARD, Category.Sport);
        addQuestion(q57);
        Question q58 = new Question("In which year was the first ever Wimbledon tennis tournament held?",
                "1999", "1877", "2018", 2,
                Question.DIFFICULTY_HARD, Category.Sport);
        addQuestion(q58);
        Question q59 = new Question("Who was the only Pakistani who won doubles final of the U.S open tennis?",
                "Aisam Ul Haq with Rohan Bopana", "Waseem Akram with Imran Khan", "None of the above", 1,
                Question.DIFFICULTY_HARD, Category.Sport);
        addQuestion(q59);
        Question q60 = new Question("Which is the national game of Brazil",
                "Tennis", "Football", "BasketBall", 2,
                Question.DIFFICULTY_HARD, Category.Sport);
        addQuestion(q60);

        //easy Famous Places

        Question q61 = new Question("Which of the following cities is known as Electronic City of India?",
                "Mumbai", "Bangalore", "Hyderabad", 2,
                Question.DIFFICULTY_EASY, Category.Famous_Places);
        addQuestion(q61);
        Question q62 = new Question("Smallest country in the world is",
                "Vatican City", "Tonga", "Monaco", 1,
                Question.DIFFICULTY_EASY, Category.Famous_Places);
        addQuestion(q62);
        Question q63 = new Question("Taj Mahal is located in which Country?",
                "India", "Pakstan", "Banlgadesh", 1,
                Question.DIFFICULTY_EASY, Category.Famous_Places);
        addQuestion(q63);
        Question q64 = new Question("Victoria Falls is located between which two countries?",
                "Senegal-Botswana", "Zambia & Zimbawe", "Tanzania-Kenya", 2,
                Question.DIFFICULTY_EASY, Category.Famous_Places);
        addQuestion(q64);
        Question q65 = new Question("The famous Pyramids of Giza are located in which country?",
                "Lebanon", "Iraq", "Egypt", 3,
                Question.DIFFICULTY_EASY, Category.Famous_Places);
        addQuestion(q65);
        Question q66 = new Question("Mount Everest is located in which continent?",
                "Asia", "Africa", "Europe", 1,
                Question.DIFFICULTY_EASY, Category.Famous_Places);
        addQuestion(q66);
        Question q67 = new Question("Mecca is located in?",
                "Kuwait", "Saudi Arabia", "Oman", 2,
                Question.DIFFICULTY_EASY, Category.Famous_Places);
        addQuestion(q67);
        Question q68 = new Question("Valley of kings is located in which country?",
                "Turkey", "Egypt", "Itlay", 2,
                Question.DIFFICULTY_EASY, Category.Famous_Places);
        addQuestion(q68);
        Question q69 = new Question("Dead sea is loacated in which two countries?",
                "Israel-Jordan", "Iran-Iraq", "Turkey-Iraq", 1,
                Question.DIFFICULTY_EASY, Category.Famous_Places);
        addQuestion(q69);
        Question q70 = new Question("Burj Al Arab is located in?",
                "Bahrain", "Kuwait", "United Arab Emirates", 3,
                Question.DIFFICULTY_EASY, Category.Famous_Places);
        addQuestion(q70);

        //Medium

        Question q71 = new Question("Where is learning Tower of Pisa?",
                "France", "Itlay", "Switzerand", 2,
                Question.DIFFICULTY_MEDIUM, Category.Famous_Places);
        addQuestion(q71);
        Question q72 = new Question("The famous Meenakshi temple is in",
                "Gujarat", "Orissa", "Tamil Nadu", 3,
                Question.DIFFICULTY_MEDIUM, Category.Famous_Places);
        addQuestion(q72);
        Question q73 = new Question("Where is the National Remote Sensing Agency situated?",
                "Shadnagar", "Chennai", "Bangalore", 1,
                Question.DIFFICULTY_MEDIUM, Category.Famous_Places);
        addQuestion(q73);
        Question q74 = new Question("Which of the following monuments is oldest?",
                "Khajurah", "Ajanta Caves", "Taj Mahal", 2,
                Question.DIFFICULTY_MEDIUM, Category.Famous_Places);
        addQuestion(q74);
        Question q75 = new Question("The first Financial Service Park for industry is being set up at",
                "Pune", "Surat", "Gurgaon", 3,
                Question.DIFFICULTY_MEDIUM, Category.Famous_Places);
        addQuestion(q75);
        Question q76 = new Question("Waterloo is located in",
                "Belgium", "England", "France", 1,
                Question.DIFFICULTY_MEDIUM, Category.Famous_Places);
        addQuestion(q76);
        Question q77 = new Question("World Resources Institue is located in which city?",
                "NewYork", "Oslo", "None of these", 3,
                Question.DIFFICULTY_MEDIUM, Category.Famous_Places);
        addQuestion(q77);
        Question q78 = new Question("The Yellow Stone National Park is in",
                "France", "China", "U.S.A", 3,
                Question.DIFFICULTY_MEDIUM, Category.Famous_Places);
        addQuestion(q78);
        Question q79 = new Question("Where Advanced Center for Marine Biology Research is located?",
                "Tuticorin", "Chennai", "Parangipettai", 1,
                Question.DIFFICULTY_MEDIUM, Category.Famous_Places);
        addQuestion(q79);
        Question q80 = new Question("The state with smallest population is",
                "Goa", "Sikkim", "Meghalaya", 2,
                Question.DIFFICULTY_MEDIUM, Category.Famous_Places);
        addQuestion(q80);

        //Hard Famous_places
        Question q81 = new Question("Machu Picchu is loacted in which country?",
                "Peru", "Jamaica", "Cuba", 1,
                Question.DIFFICULTY_HARD, Category.Famous_Places);
        addQuestion(q81);
        Question q82 = new Question("Bali is located in which country",
                "India", "Philippines", "Indonesia", 3,
                Question.DIFFICULTY_HARD, Category.Famous_Places);
        addQuestion(q82);

        Question q83 = new Question("Ngorongoro Crater is located in which country?",
                "Tennis", "Football", "BasketBall", 2,
                Question.DIFFICULTY_HARD, Category.Famous_Places);
        addQuestion(q83);

        Question q84 = new Question("Which leaning tower lean the most?",
                "Tower of Pisa", "Tower of Shiraz ", "Tower of Suurhusen", 3,
                Question.DIFFICULTY_HARD, Category.Famous_Places);
        addQuestion(q84);
        Question q85 = new Question("Where is the famous Shipwreck Bay?",
                "In Zakynthos", "In Crete", "In Kos", 1,
                Question.DIFFICULTY_HARD, Category.Famous_Places);
        addQuestion(q85);
        Question q86 = new Question("Where is the second largest Greek island?(after Crete)",
                "Rhodes", "Euboea", "Lesbos", 2,
                Question.DIFFICULTY_HARD, Category.Famous_Places);
        addQuestion(q86);
        Question q87 = new Question("Which empire did the privateer and admiral Barbarossa fight for?",
                "England", "Spain", "The Ottoman Empire", 3,
                Question.DIFFICULTY_HARD, Category.Famous_Places);
        addQuestion(q87);
        Question q88 = new Question("Which major German company was founded by the Nazis? ",
                "Volkswagen", "Bayer", "All of them", 1,
                Question.DIFFICULTY_HARD, Category.Famous_Places);
        addQuestion(q88);
        Question q89 = new Question("Which luxury fashion house manufactured uniform for SS using slave laborers?",
                "Gucci", "Hugo Boss", "Prada", 2,
                Question.DIFFICULTY_HARD, Category.Famous_Places);
        addQuestion(q89);
        Question q90 = new Question("What does the term 'Haute couture' means?",
                "High sewing", "Dress adoration", "Hand sewing", 1,
                Question.DIFFICULTY_HARD, Category.Famous_Places);
        addQuestion(q90);

        //easy technology

        Question q91 = new Question("Which one is the first search engine in internet?",
                "Archie", "Google", "WAIS", 1,
                Question.DIFFICULTY_EASY, Category.Technology);
        addQuestion(q91);

        Question q92 = new Question("Number of bit used by IPv6 address?",
                " 32 bit", "64 bit", "128 bit", 3,
                Question.DIFFICULTY_EASY, Category.Technology);
        addQuestion(q92);

        Question q93 = new Question("First computer virus is known as?",
                "Creeper Virus", "Rabbit", "SCA virus", 1,
                Question.DIFFICULTY_EASY, Category.Technology);
        addQuestion(q93);

        Question q94 = new Question("Which one programming language is exclusively used in artificial intelligence",
                "J2EE", "Prolog", "Java", 2,
                Question.DIFFICULTY_EASY, Category.Technology);
        addQuestion(q94);

        Question q95 = new Question("Which one of the foloowing is not an operating system",
                "DOS", "C", "Linux", 2,
                Question.DIFFICULTY_EASY, Category.Technology);
        addQuestion(q95);

        Question q96 = new Question("Mac operating system is developed by which company?",
                "IBM", "Apple", "Microsoft", 2,
                Question.DIFFICULTY_EASY, Category.Technology);
        addQuestion(q96);

        Question q97 = new Question(".gif is an extension of ",
                "Image file", "Video file", "Word file", 1,
                Question.DIFFICULTY_EASY, Category.Technology);
        addQuestion(q97);

        Question q98 = new Question("Where is the headquater of Microsoft office located",
                "Washington", "NewYork", "California", 1,
                Question.DIFFICULTY_EASY, Category.Technology);
        addQuestion(q98);

        Question q99 = new Question("Who created C programminh language ",
                "Ken Thompson", "Dennis Ritchie", "Frieder Nake", 2,
                Question.DIFFICULTY_EASY, Category.Technology);
        addQuestion(q99);

        Question q100 = new Question("Who is known as the father of internet",
                "Steve Lawrnece", "Vint Cerf", " Alan Perlis", 2,
                Question.DIFFICULTY_EASY, Category.Technology);
        addQuestion(q100);

        // medium technology

        Question q101 = new Question("What is measured by the sling Pyschrometer?",
                "Humidity", "Temperature", "Pressure", 1,
                Question.DIFFICULTY_MEDIUM, Category.Technology);
        addQuestion(q101);

       Question q102 = new Question("Who invented Telegraph?",
                "Alexander Graham Bell ", "Samuel Morse", "Edward Jenner",2 ,
                Question.DIFFICULTY_MEDIUM, Category.Technology);
        addQuestion(q102);

        Question q103 = new Question("Rubber is a product of?",
                "Latex", "Fibre", "Gum", 1,
                Question.DIFFICULTY_MEDIUM, Category.Technology);
        addQuestion(q103);

        Question q104 = new Question("Communication satellite are used to",
                "Transmit communication signal only", "Receive and redirect communication signals", "Provide information of natural resources only", 2,
                Question.DIFFICULTY_MEDIUM, Category.Technology);
        addQuestion(q104);

        Question q105 = new Question("Who invented the video-tape",
                "Richard James", "Charles Ginsberg", "P.T.Franswoth", 2,
                Question.DIFFICULTY_MEDIUM, Category.Technology);
        addQuestion(q105);

        Question q106 = new Question("When was color TV transmission introduced in india",
                "1982", "1984", "1980", 1,
                Question.DIFFICULTY_MEDIUM, Category.Technology);
        addQuestion(q106);

        Question q107 = new Question("Which of the following in automobile can cause cancer? ",
                "Lead", "Carbon monoxide", " Oxides of nitrogen", 2,
                Question.DIFFICULTY_MEDIUM, Category.Technology);
        addQuestion(q107);

        Question q108 = new Question("Fountain pen was invented by?",
                "C.V.Raman", "Vannevar Bush", "Lewis E.Waterman", 3,
                Question.DIFFICULTY_MEDIUM, Category.Technology);
        addQuestion(q108);

        Question q109 = new Question("Which of the following domain is used for profit businesses?",
                ".net", ".edu", ".com", 3,
                Question.DIFFICULTY_MEDIUM, Category.Technology);
        addQuestion(q109);

        Question q110 = new Question("The first network of internet was",
                "LAN", "Intranet", " WAN", 2,
                Question.DIFFICULTY_MEDIUM, Category.Technology);
        addQuestion(q110);

        //difficult technology

        Question q111 = new Question("The first programmer to write progrmmes for Babbage's Analytical Engine was",
                "Lady Ada Lovelace", "Grace Hopper", " Brian Kernighan", 1,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q111);

        Question q112 = new Question("The first object oriented programming language is",
                "Python", "Ruby", " SIMULA 67", 3,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q112);

        Question q113 = new Question("The first programmable computer was developed by Konrad Zuse was",
                "Z3", "A3", " Z2", 3,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q113);

        Question q114 = new Question("The first algorithmic programming language was",
                "Fortan", "Plankalkuel", " C", 2,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q114);

        Question q115= new Question("The frist ever language used on an electronic computing device is",
                "LISP", "Prolog", " Short Code", 3,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q115);

        Question q116 = new Question("Color temperature is related to what camera setting?",
                "Resolution", "Aperture", "White balnce", 3,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q116);

        Question q117 = new Question("What type of label contains vertica bar and a 12-digit number?",
                "SKU", "PID", " UPC", 3,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q117);

        Question q118 = new Question("Deleting all the messgaes in your inbox is also called what?",
                "Email bomb", "Email blast", "Email bankruptcy", 3,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q118);

        Question q119 = new Question("Which connection uses pulses of light to transfer data?",
                "Toslink", "USB 2.0", "Firewire", 1,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q119);

        Question q120 = new Question("Which of the following is not an impact printer?",
                "Laser Printer", "Dot matrix printer", "Daisy-wheel printer", 1,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q120);

        Question q121 = new Question("The result of a mathematical calculation may also be considered what? ",
                "Throughput", "Output", "Goodput", 2,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q121);

        Question q122 = new Question("QBE is an alternative to manually writing what? ",
                "Web pages", "Mobile apps", "SQL queries", 3,
                Question.DIFFICULTY_HARD, Category.Technology);
        addQuestion(q122);

        //easy general knowldge
        Question q123 = new Question("The language spoken by the people of Pakistan is? ",
                "Hindi", "Urdu", "Punjabi", 2,
                Question.DIFFICULTY_EASY, Category.Genral_Knowledge);
        addQuestion(q123);

        Question q124 = new Question("Which is the fastest animla on the land?",
                "Lion", "Cheetah", "Tiger", 2,
                Question.DIFFICULTY_EASY, Category.Genral_Knowledge);
        addQuestion(q124);

        Question q125 = new Question("Which is the most sensitive organ in our body? ",
                "Eye", "Heart", "Skin", 3,
                Question.DIFFICULTY_EASY, Category.Genral_Knowledge);
        addQuestion(q125);

        Question q126 = new Question("What is the standard taste of water? ",
                "Bitter", "No taste", "Sweet", 2,
                Question.DIFFICULTY_EASY, Category.Genral_Knowledge);
        addQuestion(q126);

        Question q127 = new Question("The biggest part of the brain is?",
                "Spinal cord", "Cerebrum", "Brain Stem", 2,
                Question.DIFFICULTY_EASY, Category.Genral_Knowledge);
        addQuestion(q127);

        Question q128 = new Question("At room temperature which is the only metal that is in liquid form?",
                "Mercury", "Iron", "Silver", 1,
                Question.DIFFICULTY_EASY, Category.Genral_Knowledge);
        addQuestion(q128);

        Question q129= new Question("In which country are the cities Ankara and Istanbul located?",
                "Afghanistan", "Turkey", "Iraq", 2,
                Question.DIFFICULTY_EASY, Category.Genral_Knowledge);
        addQuestion(q129);

        Question q130 = new Question("Which planet have the 'Great Red Spot?' ",
                "Jupiter", "Mercury", "Venus", 1,
                Question.DIFFICULTY_EASY, Category.Genral_Knowledge);
        addQuestion(q130);

        Question q131 = new Question("Name of vegetable which is also known as flower?",
                "Broccoli", "Cauliflower", "Sunflower", 1,
                Question.DIFFICULTY_EASY, Category.Genral_Knowledge);
        addQuestion(q131);

        Question q132 = new Question("Which country's football team has lifted the 2018 International Cup football title? ",
                "Argentina", "India", "Srilanka", 2,
                Question.DIFFICULTY_EASY, Category.Genral_Knowledge);
        addQuestion(q132);

        //medium general knowledge

        Question q133 = new Question("In which country did gold originate? ",
                "Scotland", "HongKong", "Itlay", 1,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q133);

        Question q134 = new Question("In which sport,since its inception as a competition event, have the blacks dominated the whites?",
                "Basketball", "Archery", "Boxing", 3,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q134);

        Question q135 = new Question("Which has the largest arm forces relative to the size of its population?",
                "Iraq", "Afghanistan", "Iran", 3,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q135);

        Question q136 = new Question("With which sport does the term googly associated?",
                "Cricket", "Hockey", "Badminton", 1,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q136);

        Question q137 = new Question("How many holes are there in a standard golf course,which is usually 5.5km in length?",
                "18", "19", "17", 1,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q137);

        Question q138 = new Question("Exposure to sunlight help a person improve his health because",
                "resistance power increases", "the ultraviolet rays convert skin oil into vitamin D", "the infraded light kills bacteria in the body", 2,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q138);

        Question q139 = new Question("First Afghan war took place in ",
                "1848", "1839", "1833", 2,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q139);

        Question q140 = new Question("Each year World Red Cross and Red Crescent Day is celebrated on",
                "May 8", "June 8", "July 8", 1,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q140);

        Question q141 = new Question("Friction can be reduced by changing from",
                "Sliding to rolling", "Dynamic to static", "potential energy to kinetic energy", 1,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q141);

        Question q142 = new Question("First temple is the place of worship oof which of the following religion? ",
                "Taoism", "Zoroastrianism", "Judaism", 2,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q142);

        Question q143 = new Question("Film and TV institute of India is located at ",
                "Rajkot(Gujarat)", "Perambur(Tamilnadu)", "Pune(Maharashtra)", 3,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q143);

        Question q144 = new Question("Geogria,Uzbekistan and Turkmenistan became the members of UNO in",
                "1991", "1992", "1993", 2,
                Question.DIFFICULTY_MEDIUM, Category.Genral_Knowledge);
        addQuestion(q144);

        //Hard general knowledge

        Question q145 = new Question("What are the colors of Russian flag?",
                "Red,Yellow,White", "White,Blue,Red", "Blue,White,Yellow", 2,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q145);

        Question q146 = new Question("Marie Curie was the first woman to win which award?",
                "Nobel Prize in literature", "Nobel Prize in Chemistry", "Nobel Peace Prize", 2,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q146);

        Question q147 = new Question("Which is the surname of the female lead in 'Romeo and Juliet'",
                "Laurence", "Montague", "Capulet", 3,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q147);

        Question q148 = new Question("Who has won the most medals in Olymphic history",
                "Ryan Lochte", "Usain Bolt", "Michael Phelps", 3,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q148);

        Question q149 = new Question("What is the study of Heart known as ",
                "Mycology", " Cardiology", " Pharmacology", 2,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q149);

        Question q150 = new Question("Brass is an alloy of which two metals?",
                "Copper and Zinc", "Zinc and Mercury", "Lead and Tin", 1,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q150);

        Question q151 = new Question("Who is the author of 'The Hunger Games'",
                "John Green", "Suzanne Collins", "E.L.James", 2,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q151);

        Question q152 = new Question("For what kind of sport do you need an Epee",
                "Fencing", "High Jum", "Rowing", 1,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q152);

        Question q153 = new Question("Who received the 'BALLON D'OR' in 2015?",
                "Cristiano Ronaldo", "Lionel Messi", "Gareth Bale", 2,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q153);

        Question q154 = new Question("Sacramento is the state capital of which state in the USA?",
                "Florida", "California", "Texas", 2,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q154);

        Question q155 = new Question("George Orwell is the author of which of the classic book?",
                "Jan Eyre", "1984", "Pride and Prejudice", 2,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q155);

        Question q156 = new Question("Which country is popularly called 'The Land of the Maple Leaf?'",
                "Canada", "Itlay", "Japan", 1,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q156);

        Question q157 = new Question("When did England last win the football world cup?",
                "1967", "1965", "1966", 3,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q157);

        Question q158 = new Question("Which planet is named after the Roman god of war?",
                "Mars", "Pluto", "Venus", 1,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q158);

        Question q159 = new Question("How many cents are there in a Australian dollar",
                "5", "10", "100", 3,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q159);

        Question q160 = new Question("Which of these equations has the same result as 4 to the power of 3?",
                "3*3*3*3", "4*3", "8*8", 3,
                Question.DIFFICULTY_HARD, Category.Genral_Knowledge);
        addQuestion(q160);


    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            }
            while (c.moveToNext());
        }
        c.close();
        return categoryList;
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestions(int categoryID, String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = QuestionsTable.COLUMN_CATEGORY_ID + " = ? " +
                " AND " + QuestionsTable.COLUMN_DIFFICULTY + " = ? ";

        String[] selectionArgs = new String[]{String.valueOf(categoryID), difficulty};
        Cursor c = db.query(

                QuestionsTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}