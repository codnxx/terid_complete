package com.example.terid_off;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.terid_off.QuizContract.*;

import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private static QuizDbHelper instance;

    private SQLiteDatabase db;

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
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
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
        Category c1 = new Category("DAY1");
        addCategory(c1);
        Category c2 = new Category("DAY2");
        addCategory(c2);
        Category c3 = new Category("DAY3");
        addCategory(c3);
        Category c4 = new Category("DAY4");
        addCategory(c4);
        Category c5 = new Category("DAY5");
        addCategory(c5);
        Category c6 = new Category("DAY6");
        addCategory(c6);
        Category c7 = new Category("DAY7");
        addCategory(c7);
        Category c8 = new Category("DAY8");
        addCategory(c8);
        Category c9 = new Category("DAY9");
        addCategory(c9);
        Category c10 = new Category("DAY10");
        addCategory(c10);
        Category c11 = new Category("DAY11");
        addCategory(c11);
        Category c12 = new Category("DAY12");
        addCategory(c12);
        Category c13 = new Category("DAY13");
        addCategory(c13);
        Category c14 = new Category("DAY14");
        addCategory(c14);
        Category c15 = new Category("DAY15");
        addCategory(c15);
        Category c16 = new Category("DAY16");
        addCategory(c16);
        Category c17 = new Category("DAY17");
        addCategory(c17);
        Category c18 = new Category("DAY18");
        addCategory(c18);
        Category c19 = new Category("DAY19");
        addCategory(c19);
        Category c20 = new Category("DAY20");
        addCategory(c20);
        Category c21 = new Category("DAY21");
        addCategory(c21);
        Category c22 = new Category("DAY22");
        addCategory(c22);
        Category c23 = new Category("DAY23");
        addCategory(c23);
        Category c24 = new Category("DAY24");
        addCategory(c24);
        Category c25 = new Category("DAY25");
        addCategory(c25);
        Category c26 = new Category("DAY26");
        addCategory(c26);
        Category c27 = new Category("DAY27");
        addCategory(c27);
        Category c28 = new Category("DAY28");
        addCategory(c28);
        Category c29 = new Category("DAY29");
        addCategory(c29);
        Category c30 = new Category("DAY30");
        addCategory(c30);
    }

    private void addCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);
    }

    private void fillQuestionsTable() {
        Question q1_1 = new Question("To _______ the repair job on time, the engineer asked the carpenters and electricians to do overtime yesterday.",
                "(A) finished", "(B) finishing", "(C) finishes", "(D) finish", 4, Category.DAY1);
        addQuestion(q1_1);
        Question q2_1 = new Question("The union leader plans to _______ his remarks on work safety problems to the management during the meeting this afternoon.",
                "(A) address", "(B) exalt", "(C) broadcast", "(D) send", 1, Category.DAY1);
        addQuestion(q2_1);
        Question q3_1 = new Question("_______ to secure your export products, we recommend that you have them insured before shipment.",
                "(A) In order", "(B) So that", "(C) Though", "(D) Because", 1, Category.DAY1);
        addQuestion(q3_1);
        Question q4_1 = new Question("The consultant was impressed that the draftsmen worked efficiently even without the _______ of a design director.",
                "(A) standard", "(B) correction", "(C) supervision", "(D) accuracy", 3, Category.DAY1);
        addQuestion(q4_1);
        Question q5_1 = new Question("Jerry Cunningham will _______ the names of researchers and production assistants who will join Ms. Marina Fletcher at the Paris Film Festival.",
                "(A) announce", "(B) diffuse", "(C) trade", "(D) command", 1, Category.DAY1);
        addQuestion(q5_1);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_2 = new Question("With all the negative reviews about the novel, it seems that the author’s message was _______ by literary critics.",
                "(A) misinterpret", "(B) misinterprets", "(C) misinterpreting", "(D) misinterpreted", 4, Category.DAY2);
        addQuestion(q1_2);
        Question q2_2 = new Question("The painting's monetary worth in the arts market _______ when it was discovered that it was one of the earliest works done by the renowned artist Van Gogh.",
                "(A) doubled", "(B) rolled", "(C) plunged", "(D) overlapped", 1, Category.DAY2);
        addQuestion(q2_2);
        Question q3_2 = new Question("Ellen's probationary status was extended by _______ month after it was discovered that she had no actual experience in accounting procedures.",
                "(A) more", "(B) other", "(C) another", "(D) one another", 3, Category.DAY2);
        addQuestion(q3_2);
        Question q4_2 = new Question("If you would like to cancel or make any changes to your order, please include your order number on the subject line in all _______ to customer service.",
                "(A) incidence", "(B) correspondence", "(C) adherence", "(D) assistance", 2, Category.DAY2);
        addQuestion(q4_2);
        Question q5_2 = new Question("_______ last minute finishing touches in decorating the venue, preparations for the community ball to be held in the afternoon are complete.",
                "(A) But for", "(B) On account of", "(C) In place of", "(D) Instead of", 1, Category.DAY2);
        addQuestion(q5_2);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_3 = new Question("Clients interested in holding social or business gatherings at the Mayfair Hotel may inquire about the availability of function rooms at _______ reception area or on the hotel’s website.",
                "(A) us", "(B) ours", "(C) ourselves", "(D) our", 4, Category.DAY3);
        addQuestion(q1_3);
        Question q2_3 = new Question("The most recent economic crisis resulted in the near collapse of Smart Savings Bank, a highly _______ financial institution in Asia and Europe.",
                "(A) recognizes", "(B) recognized", "(C) has recognized", "(D) recognizing", 2, Category.DAY3);
        addQuestion(q2_3);
        Question q3_3 = new Question("The national economy has been _______ for nearly two years because of the impact of global recession.",
                "(A) stagnant", "(B) stagnancy", "(C) stagnating", "(D) stagnantly", 1, Category.DAY3);
        addQuestion(q3_3);
        Question q4_3 = new Question("Garbage, _______ biodegradable or non-biodegradable, should be thrown into designated trash cans within the park.",
                "(A) whenever", "(B) until", "(C) also", "(D) whether", 4, Category.DAY3);
        addQuestion(q4_3);
        Question q5_3 = new Question("At the general assembly, the manager thanked the employees for giving their full _______ to the company.",
                "(A) collection", "(B) commitment", "(C) relation", "(D) duration", 2, Category.DAY3);
        addQuestion(q5_3);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_4 = new Question("Mr. Forester is confident that _______ can convince the Japanese investors to do further business with our company.",
                "(A) you", "(B) yours", "(C) yourself", "(D) your", 1, Category.DAY4);
        addQuestion(q1_4);
        Question q2_4 = new Question("Customers cannot claim their cash remittance _______ presenting valid identification, such as a driver’s license and passport.",
                "(A) without", "(B) around", "(C) onto", "(D) along", 1, Category.DAY4);
        addQuestion(q2_4);
        Question q3_4 = new Question("Due to the economic crisis, many companies all over the world are _______ to reduce operating costs next year.",
                "(A) expectedly", "(B) expected", "(C) expectation", "(D) expectant", 2, Category.DAY4);
        addQuestion(q3_4);
        Question q4_4 = new Question("Low sales recorded by Blued Clothing last year was primarily due to its _______ popularity in the market.",
                "(A) retractable", "(B) transferable", "(C) minimizing", "(D) declining", 4, Category.DAY4);
        addQuestion(q4_4);
        Question q5_4 = new Question("Climate in different parts of the world has become _______ unpredictable because of global warming.",
                "(A) increase", "(B) increasable", "(C) increasingly", "(D) increased", 3, Category.DAY4);
        addQuestion(q5_4);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_5 = new Question("Overtime requests must be _______ by employees’ immediate supervisors and the personnel department.",
                "(A) approved", "(B) delivered", "(C) initiated", "(D) founded", 1, Category.DAY5);
        addQuestion(q1_5);
        Question q2_5 = new Question("If you would like to _______ another venue for the party, please contact the events coordinator on her mobile phone.",
                "(A) suggest", "(B) comment", "(C) release", "(D) advocate", 1, Category.DAY5);
        addQuestion(q2_5);
        Question q3_5 = new Question("ExD Enterprise Incorporated is the leading local _______ of imported contact lenses in the country.",
                "(A) distributed", "(B) distributing", "(C) distributor", "(D) distribution", 3, Category.DAY5);
        addQuestion(q3_5);
        Question q4_5 = new Question("The food packaging process is _______ checked by a team of well-trained quality control staff.",
                "(A) sensitively", "(B) carefully", "(C) prominently", "(D) importantly", 2, Category.DAY5);
        addQuestion(q4_5);
        Question q5_5 = new Question("Pedestrians are advised to be _______ and look both ways before crossing the street.",
                "(A) cautionary", "(B) cautioning", "(C) cautious", "(D) cautions", 3, Category.DAY5);
        addQuestion(q5_5);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_6 = new Question("To purchase the items using your credit card, please _______ your credit card number and card expiration date in the boxes below.",
                "(A) pass", "(B) enter", "(C) make", "(D) accept", 2, Category.DAY6);
        addQuestion(q1_6);
        Question q2_6 = new Question("During the meeting, the head editor asked writers to attend a grammar workshop because their language errors had become increasingly _______.",
                "(A) repeater", "(B) repeats", "(C) repetitive", "(D) repetitively", 3, Category.DAY6);
        addQuestion(q2_6);
        Question q3_6 = new Question(".Organizers from local government have planned a whole day event at the Waterford Park near City Hall to honor the city's _______ Brendan O'Connell.",
                "(A) founder", "(B) found", "(C) founding", "(D) founded", 1, Category.DAY6);
        addQuestion(q3_6);
        Question q4_6 = new Question("The construction crew has _______ completed renovating the hospital ward, after which new machines for the pediatric center will be brought in.",
                "(A) thereby", "(B) almost", "(C) near", "(D) nowadays", 2, Category.DAY6);
        addQuestion(q4_6);
        Question q5_6 = new Question("The demand for handheld devices such as tablets and cell phones _______ South Asia has not been as intense as in East Asia, but it is steadily rising.",
                "(A) beyond", "(B) along", "(C) across", "(D) among", 3, Category.DAY6);
        addQuestion(q5_6);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_7 = new Question("Automobile factories in areas _______ affected by heavy rains postponed operations last week.",
                "(A) severity", "(B) severely", "(C) severest", "(D) severer", 2, Category.DAY7);
        addQuestion(q1_7);
        Question q2_7 = new Question("Once you have completed the customer data form, please write your _______ on the back page of the document.",
                "(A) signed", "(B) signs", "(C) signature", "(D) signage", 3, Category.DAY7);
        addQuestion(q2_7);
        Question q3_7 = new Question("These agricultural _______ are intended to provide adequate funds and technical support for farmers in the rural areas.",
                "(A) reforming", "(B) reformative", "(C) reforms", "(D) reformation", 3, Category.DAY7);
        addQuestion(q3_7);
        Question q4_7 = new Question("The letter states that _______ delegates will be accommodated at nearby hotels and provided meals at the expense of the convention organizer.",
                "(A) invited", "(B) inviting", "(C) invitation", "(D) to invite", 1, Category.DAY7);
        addQuestion(q4_7);
        Question q5_7 = new Question(".If the participants have _______ suggestions, please request them to include their insights on the evaluation form that will be distributed at the end of the workshop.",
                "(A) spare", "(B) potential", "(C) optional", "(D) further", 4, Category.DAY7);
        addQuestion(q5_7);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_8 = new Question("During trainings with probationary employees, the instructors break the ice by _______ a session with interesting stories about the computer industry.",
                "(A) governing", "(B) preceding", "(C) controlling", "(D) supervising", 2, Category.DAY8);
        addQuestion(q1_8);
        Question q2_8 = new Question("According to the advertisement, Iron Gym and Sports Center _______ free tennis lessons to new members.",
                "(A) will have offered", "(B) has been offered", "(C) to offer", "(D) is offering", 4, Category.DAY8);
        addQuestion(q2_8);
        Question q3_8 = new Question("One of the waiters _______ about to close the restaurant when a customer arrived to inquire about catering services.",
                "(A) was", "(B) is", "(C) were", "(D) are", 1, Category.DAY8);
        addQuestion(q3_8);
        Question q4_8 = new Question("Our function rooms and conference halls are _______ and adequately equipped with multimedia systems.",
                "(A) space", "(B) spacious", "(C) spaciously", "(D) spacer", 2, Category.DAY8);
        addQuestion(q4_8);
        Question q5_8 = new Question("Rooms for the Asian cruise were _______ booked because of the special discount offered to corporate groups.",
                "(A) totaling", "(B) totality", "(C) totally", "(D) totals", 3, Category.DAY8);
        addQuestion(q5_8);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_9 = new Question("All items deposited at the baggage counter should be claimed _______ the department store closes.",
                "(A) from", "(B) because", "(C) inside", "(D) before", 4, Category.DAY9);
        addQuestion(q1_9);
        Question q2_9 = new Question("The brand manager recommended changing the scent of their perfume due to _______ feedback from consumers.",
                "(A) plain", "(B) inspiring", "(C) unfavorable", "(D) accidental", 3, Category.DAY9);
        addQuestion(q2_9);
        Question q3_9 = new Question("Wheeler Corporation will _______ a temporary information and support website for customers whose vehicles were recalled due to a defective brake system.",
                "(A) bring to", "(B) look over", "(C) set up", "(D) write down", 3, Category.DAY9);
        addQuestion(q3_9);
        Question q4_9 = new Question("Sales agents who work in assigned territories to distribute the company's products are able to earn a _______ income even though they are on commission basis.",
                "(A) sizable", "(B) size", "(C) sizably", "(D) sizableness", 1, Category.DAY9);
        addQuestion(q4_9);
        Question q5_9 = new Question("Revenues for this quarter were expected to be about the same as in the previous period, but the accounting manager reported that it was _______ much higher.",
                "(A) usually", "(B) suitably", "(C) partially", "(D) actually", 4, Category.DAY9);
        addQuestion(q5_9);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_10 = new Question("The theme park’s _______ is to restrict boarding participation on rides that may be dangerous to those who have medical issues.",
                "(A) display", "(B) development", "(C) process", "(D) policy", 4, Category.DAY10);
        addQuestion(q1_10);
        Question q2_10 = new Question("Ms. Tan considered hiring a real property broker to help her choose the _______ office space for her company.",
                "(A) appropriate", "(B) destined", "(C) fortunate", "(D) insightful", 1, Category.DAY10);
        addQuestion(q2_10);
        Question q3_10 = new Question("According to the company handbook, salary _______ may be given in cases where an unexpected event or emergency situation imposes a financial burden on an employee.",
                "(A) advancing", "(B) advances", "(C) advanced", "(D) advancement", 2, Category.DAY10);
        addQuestion(q3_10);
        Question q4_10 = new Question("During the press conference, the spokesperson did not comment _______ the measures the government would take with regard to the recent spate of bank failures.",
                "(A) in", "(B) on", "(C) off", "(D) for", 2, Category.DAY10);
        addQuestion(q4_10);
        Question q5_10 = new Question("Armelle’s, a newly-opened restaurant on Saturn Drive, offers _______ and tasty meals to office workers who prefer not to eat at company cafeterias.",
                "(A) affordable", "(B) afforded", "(C) affordability", "(D) affords", 1, Category.DAY10);
        addQuestion(q5_10);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_11 = new Question("Maintenance workers are tasked to inspect apartment units _______ for plumbing and electrical problems and to make needed repairs.",
                "(A) periods", "(B) period", "(C) periodical", "(D) periodically", 4, Category.DAY11);
        addQuestion(q1_11);
        Question q2_11 = new Question("Although the information campaign is scheduled to begin tomorrow, an employee has _______ to print the flyers to be handed out at distribution points.",
                "(A) yet", "(B) already", "(C) even", "(D) just", 1, Category.DAY11);
        addQuestion(q2_11);
        Question q3_11 = new Question("The establishment of a branch in Thailand is expected to _______ the company's position in south Asia and increase its presence in the international market.",
                "(A) conform", "(B) condense", "(C) solidify", "(D) integrate", 3, Category.DAY11);
        addQuestion(q3_11);
        Question q4_11 = new Question("The Bristol Museum's _______ is to educate visitors on the art genres and their numerous categories as well as to increase appreciation of the arts.",
                "(A) criteria", "(B) objective", "(C) enterprise", "(D) perception", 2, Category.DAY11);
        addQuestion(q4_11);
        Question q5_11 = new Question("A colleague will be visiting to participate in a seminar, and I am wondering if the university can accommodate him in any way _______ from May 15 to 17.",
                "(A) possibility", "(B) possible", "(C) possibly", "(D) possibleness", 2, Category.DAY11);
        addQuestion(q5_11);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_12 = new Question("The CEO _______ to maximize the company's growth potential by studying the investment opportunities available and selecting the most promising.",
                "(A) exerts", "(B) trusts", "(C) aims", "(D) directs", 3, Category.DAY12);
        addQuestion(q1_12);
        Question q2_12 = new Question("_______ the keynote speaker was giving a talk on the effects of technology on society, attendees were recording his speech and preparing their questions.",
                "(A) Despite", "(B) Considering", "(C) As", "(D) During", 3, Category.DAY12);
        addQuestion(q2_12);
        Question q3_12 = new Question("_______ the exam will take four hours to finish, applicants are advised to have lunch before proceeding to the head office.",
                "(A) Until", "(B) Because", "(C) Due to", "(D) In addition", 2, Category.DAY12);
        addQuestion(q3_12);
        Question q4_12 = new Question("To accommodate more customers during weekends, the manager of Black Coffee Shop recommended _______ the outlet at 3 A.M. on Saturdays and Sundays.",
                "(A) closed", "(B) closing", "(C) will close", "(D) to close", 2, Category.DAY12);
        addQuestion(q4_12);
        Question q5_12 = new Question("Beat Asia is set to conduct a survey to _______ the public’s perception on global warming.",
                "(A) determinedly", "(B) determinant", "(C) determination", "(D) determine", 4, Category.DAY12);
        addQuestion(q5_12);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_13 = new Question("Thousands of visitors come to the park every Friday to watch the free concert, but _______ simply want to sit in a quiet place and watch people walking by.",
                "(A) any", "(B) some", "(C) other", "(D) these", 2, Category.DAY13);
        addQuestion(q1_13);
        Question q2_13 = new Question("The memo stated that the human resources director has personal matters to attend to and will _______ be on extended leave for the remainder of the year.",
                "(A) therefore", "(B) nowadays", "(C) somehow", "(D) seldom", 1, Category.DAY13);
        addQuestion(q2_13);
        Question q3_13 = new Question("At the close of the press conference, the president left immediately, _______ to give further comment on the company's decision to declare bankruptcy.",
                "(A) refuse", "(B) refusing", "(C) refused", "(D) refusal", 2, Category.DAY13);
        addQuestion(q3_13);
        Question q4_13 = new Question("As an employee on provisional status, Naomi has shown an exceptional ability to solve problems by _______.",
                "(A) she", "(B) her", "(C) herself", "(D) hers", 3, Category.DAY13);
        addQuestion(q4_13);
        Question q5_13 = new Question("Bank officials consider it neither necessary _______ advisable to confirm all information submitted by an applicant when conducting a credit investigation.",
                "(A) not only", "(B) not", "(C) either", "(D) nor", 4, Category.DAY13);
        addQuestion(q5_13);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_14 = new Question("Mr. Cruz’s rashes _______ by the time he went to the hospital to see a dermatologist.",
                "(A) are disappearing", "(B) to disappear", "(C) had disappeared", "(D) will disappear", 3, Category.DAY14);
        addQuestion(q1_14);
        Question q2_14 = new Question("Due to the _______ conditions during the political rally, the mayor asked the police force to be extra vigilant.",
                "(A) crowd", "(B) crowded", "(C) crowding", "(D) crowdedly", 2, Category.DAY14);
        addQuestion(q2_14);
        Question q3_14 = new Question("Hoping _______ the talk show and boost its ratings, producers met with the writers to discuss a change in the program’s format.",
                "(A) revamps", "(B) revamped", "(C) will revamp", "(D) to revamp", 4, Category.DAY14);
        addQuestion(q3_14);
        Question q4_14 = new Question("Under the existing agreement, both municipalities have promised that they _______ continuing trade and economic ties.",
                "(A) maintaining", "(B) maintains", "(C) will maintain", "(D) will have maintained", 3, Category.DAY14);
        addQuestion(q4_14);
        Question q5_14 = new Question("Diamond Motor Company is considering _______ 30 assembly workers in order to increase production by 50 percent during the upcoming fiscal year.",
                "(A) hire", "(B) hiring", "(C) to hire", "(D) hired", 2, Category.DAY14);
        addQuestion(q5_14);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_15 = new Question("All customers who purchase a travel package to any destination in Asia this month have the _______ of canceling at least two weeks before the travel date.",
                "(A) bonus", "(B) selection", "(C) reference", "(D) option", 4, Category.DAY15);
        addQuestion(q1_15);
        Question q2_15 = new Question("The conference room is large enough to hold 200 persons, and this will make it necessary for participants to speak _______ so that they can be heard.",
                "(A) agreeably", "(B) correctly", "(C) loudly", "(D) fully", 3, Category.DAY15);
        addQuestion(q2_15);
        Question q3_15 = new Question("The product satisfaction survey will target respondents in the southern region _______ because the item was first introduced in that locale.",
                "(A) exclusive", "(B) exclusively", "(C) exclusivity", "(D) exclusiveness", 2, Category.DAY15);
        addQuestion(q3_15);
        Question q4_15 = new Question("_______ unexpected demand for the company's kitchen floor tiles, recent orders for the merchandise will have to be placed on backlog.",
                "(A) Due to", "(B) Aside from", "(C) Even if", "(D) Provided that", 1, Category.DAY15);
        addQuestion(q4_15);
        Question q5_15 = new Question("Because of unanticipated delays in the printing phase of the book, the release of the novel has been _______ and will be reset for the first week of August.",
                "(A) discontinued", "(B) lengthened", "(C) postponed", "(D) overlooked", 3, Category.DAY15);
        addQuestion(q5_15);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_16 = new Question("The television crew paid homage to Mr. WeLafang, the network’s founding chairman, _______ his grand retirement banquet.",
                "(A) finally", "(B) during", "(C) hence", "(D) until", 2, Category.DAY16);
        addQuestion(q1_16);
        Question q2_16 = new Question("Defective merchandise may ------- with a new product of the same model within seven days of the date of purchase.",
                "(A) replacing", "(B) replace", "(C) be replaced", "(D) replaced", 3, Category.DAY16);
        addQuestion(q2_16);
        Question q3_16 = new Question("Plans for the new headquarters were drafted in ------- with the regulations and guidelines stipulated in the city’s building code.",
                "(A) accords", "(B) accorder", "(C) accorded", "(D) accordance", 4, Category.DAY16);
        addQuestion(q3_16);
        Question q4_16 = new Question("For tourists interested in the local dining experience, El Cuervo Bar and Restaurant, which ------- on Alberto Avenue, offers excellent Spanish food.",
                "(A) locating", "(B) located", "(C) locate", "(D) is located", 4, Category.DAY16);
        addQuestion(q4_16);
        Question q5_16 = new Question("The chief executive officer is looking for an innovative marketer that can help the company _______ in the global market.",
                "(A) competing", "(B) competes", "(C) compete", "(D) competed", 3, Category.DAY16);
        addQuestion(q5_16);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_17 = new Question("The details of a customer's bank transactions are considered ------- and may only be disclosed for legal purposes.",
                "(A) obsolete", "(B) public", "(C) confidential", "(D) repetitive", 3, Category.DAY17);
        addQuestion(q1_17);
        Question q2_17 = new Question("The special edition nature scene photos taken by renowned photographer Bill Miller may be purchased as a collection or _______ on our website.",
                "(A) separate", "(B) separation", "(C) separately", "(D) separating", 3, Category.DAY17);
        addQuestion(q2_17);
        Question q3_17 = new Question("Although _______ the reset button is the only way to get a computer started if the equipment stops working, technicians warn that doing so can cause data corruption.",
                "(A) pressed", "(B) pressing", "(C) presses", "(D) press", 2, Category.DAY17);
        addQuestion(q3_17);
        Question q4_17 = new Question("A new or revised policy must be fully _______ at the workplace before its impact on the company and its employees can be evaluated.",
                "(A) alleviated", "(B) maneuvered", "(C) generated", "(D) implemented", 4, Category.DAY17);
        addQuestion(q4_17);
        Question q5_17 = new Question("The company's recently-appointed executive officer will honor _______ agreements with partner firms and forge new ties with other establishments.",
                "(A) exist", "(B) existed", "(C) existing", "(D) existence", 3, Category.DAY17);
        addQuestion(q5_17);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_18 = new Question("An adviser cautioned the manager about the _______ of distributing a product in a market where the demand has not yet been fully ascertained.",
                "(A) inception", "(B) sequence", "(C) consequence", "(D) settlement", 3, Category.DAY18);
        addQuestion(q1_18);
        Question q2_18 = new Question("An assistant made hotel reservations and arranged for transportation and other services for delegates to a medical convention _______ their scheduled arrival.",
                "(A) by means of", "(B) in addition to", "(C) in case of", "(D) in advance of", 4, Category.DAY18);
        addQuestion(q2_18);
        Question q3_18 = new Question("More and more university graduates are opting to work abroad because ------- in the local job market nowadays is very stiff.",
                "(A) opposition", "(B) controversy", "(C) competition", "(D) interference", 3, Category.DAY18);
        addQuestion(q3_18);
        Question q4_18 = new Question("Medical records are kept confidential by hospital officials ------- a valid request for access is approved by a court judge.",
                "(A) unless", "(B) which", "(C) in fact", "(D) as if", 1, Category.DAY18);
        addQuestion(q4_18);
        Question q5_18 = new Question("Skyline Telecommunications, a cable and broadband service provider, has _______ telephone lines for new residents in the subdivision.",
                "(A) deported", "(B) invented", "(C) installed", "(D) mounted", 3, Category.DAY18);
        addQuestion(q5_18);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_19 = new Question("The human resources head _______ the supervisors to determine which of the new employees will be sent to the institute for additional training.",
                "(A) reunited", "(B) adjusted", "(C) convened", "(D) officiated", 3, Category.DAY19);
        addQuestion(q1_19);
        Question q2_19 = new Question("Shocked by the _______ drop in value of several small capital stocks that were previously doing well, some investors began selling their shares.",
                "(A) sudden", "(B) intricate", "(C) careless", "(D) effective", 1, Category.DAY19);
        addQuestion(q2_19);
        Question q3_19 = new Question("A conference to be attended by members of the banking community on _______ measures to curb indiscriminate lending will be suspended until next week.",
                "(A) implementation", "(B) implement", "(C) implements", "(D) implementing", 4, Category.DAY19);
        addQuestion(q3_19);
        Question q4_19 = new Question("Tourism in Europe has seen steady growth, particularly in major cities, but the United States is still the _______ earner in the industry.",
                "(A) higher", "(B) high", "(C) highest", "(D) highly", 3, Category.DAY19);
        addQuestion(q4_19);
        Question q5_19 = new Question("The editor in chief stated that as long as due credit is given, he is agreeable to reprints of articles _______ in the National Journal.",
                "(A) appearing", "(B) appearance", "(C) appeared", "(D) appear", 1, Category.DAY19);
        addQuestion(q5_19);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_20 = new Question("Meridian Company does not foresee increasing the prices of its computer components unless the _______ demand for these products escalates.",
                "(A) exclusive", "(B) feasible", "(C) conservative", "(D) current", 4, Category.DAY20);
        addQuestion(q1_20);
        Question q2_20 = new Question("The top-selling books printed by the Minton Publishing Company are reference materials _______ their romance novels are also very popular with the reading public.",
                "(A) given", "(B) although", "(C) because", "(D) following", 2, Category.DAY20);
        addQuestion(q2_20);
        Question q3_20 = new Question("The latest air conditioners utilize new technology and run more _______ than the older models, making them ideal for offices and small rooms.",
                "(A) quieter", "(B) quietest", "(C) quietness", "(D) quietly", 4, Category.DAY20);
        addQuestion(q3_20);
        Question q4_20 = new Question(".Should you have any problem with your computer or other equipment, please notify technical _______ by phone or the intranet messaging system.",
                "(A) resource", "(B) occupation", "(C) personnel", "(D) organization", 3, Category.DAY20);
        addQuestion(q4_20);
        Question q5_20 = new Question("An important customer sent in a large order for construction equipment, making it necessary to have a _______ number of workers do overtime hours for several weeks.",
                "(A) considerate", "(B) considering", "(C) considered", "(D)considerable", 4, Category.DAY20);
        addQuestion(q5_20);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_21 = new Question("Due to unavoidable circumstances, our second lecturer Bernard Cole will _______ the keynote speaker, who is now stuck in traffic on the main highway.",
                "(A) introduce", "(B) outrank", "(C) direct", "(D) precede", 4, Category.DAY21);
        addQuestion(q1_21);
        Question q2_21 = new Question("After his _______ meeting with the client, the architect had a clearer idea of the style of the office building to be constructed in the downtown area.",
                "(A) fundamental", "(B) upcoming", "(C) initial", "(D) settled", 3, Category.DAY21);
        addQuestion(q2_21);
        Question q3_21 = new Question("After calculating, the secretary _______ reached the conclusion that they had exceeded the monthly budget for business trips.",
                "(A) extensively", "(B) mistakenly", "(C) assertively", "(D) persuasively", 2, Category.DAY21);
        addQuestion(q3_21);
        Question q4_21 = new Question("Lance called the service center _______ noticing problems with the computer network, but it took a while before it sent a technician to check on the server.",
                "(A) for", "(B) upon", "(C) between", "(D) above", 2, Category.DAY21);
        addQuestion(q4_21);
        Question q5_21 = new Question("More often than not, the president chooses an officer to take care of his domestic duties _______ he has to leave for business trips in Europe.",
                "(A) whenever", "(B) whichever", "(C) whatever", "(D) whoever", 1, Category.DAY21);
        addQuestion(q5_21);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_22 = new Question("At a news conference announcing the merger of two publishing firms, a team of assistants handed out press kits _______ for reporters and newscasters.",
                "(A) prepared", "(B) prepare", "(C) to prepare", "(D) preparing", 1, Category.DAY22);
        addQuestion(q1_22);
        Question q2_22 = new Question("Staff members were forced to set their usual tasks _______ when the director asked them to prepare a financial report for investors.",
                "(A) shortly", "(B) later", "(C) nearby", "(D) aside", 4, Category.DAY22);
        addQuestion(q2_22);
        Question q3_22 = new Question("An employee who had no urgent deadlines was asked to _______ the workload of a female employee who had suddenly taken ill in the morning.",
                "(A) consider", "(B) assume", "(C) gather", "(D) endorse", 2, Category.DAY22);
        addQuestion(q3_22);
        Question q4_22 = new Question("The real estate developers signed an agreement _______ the subdivision of residential high-rise buildings close to the international airport.",
                "(A) locates", "(B) locating", "(C) to locate", "(D) locate", 3, Category.DAY22);
        addQuestion(q4_22);
        Question q5_22 = new Question("The office has a number of computers _______ will be ready for use once the new employees begin working.",
                "(A) when", "(B) whose", "(C) whom", "(D) which", 4, Category.DAY22);
        addQuestion(q5_22);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_23 = new Question("_______ one hundred high school students in rural areas received scholarships from Gastron Inc. this school year.",
                "(A) Beside", "(B) Among", "(C) From", "(D) Over", 4, Category.DAY23);
        addQuestion(q1_23);
        Question q2_23 = new Question("To prevent injury, amusement ride operators should make certain that a mechanical device’s restraint system will stay _______ secured throughout the ride.",
                "(A) completed", "(B) completely", "(C) complete", "(D) completes", 2, Category.DAY23);
        addQuestion(q2_23);
        Question q3_23 = new Question("Every month, the hospital administrator _______ a group to discuss medical approaches that may be utilized in the most complex cases.",
                "(A) activates", "(B) prescribes", "(C) assembles", "(D) inaugurates", 3, Category.DAY23);
        addQuestion(q3_23);
        Question q4_23 = new Question("A study on women’s magazines indicated that female readers have a _______ leaning toward content with familiar settings and characters.",
                "(A) transparent", "(B) literal", "(C) figurative", "(D) definite", 4, Category.DAY23);
        addQuestion(q4_23);
        Question q5_23 = new Question("The finance department divided up the quarterly profits from retail sales and online advertisement revenue _______ the stockholders.",
                "(A) throughout", "(B) within", "(C) among", "(D) upon", 3, Category.DAY23);
        addQuestion(q5_23);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_24 = new Question("To _______ free repair and battery replacement services, please fill out the warranty slip attached to the watch’s manual.",
                "(A) collect", "(B) conceal", "(C) endorse", "(D) gurantee", 4, Category.DAY24);
        addQuestion(q1_24);
        Question q2_24 = new Question("If the weather in Vietnam _______ so inclement, flight PR632 would have set down at the international airport as scheduled.",
                "(A) had not been", "(B) will not be", "(C) has not been", "(D) is not", 1, Category.DAY24);
        addQuestion(q2_24);
        Question q3_24 = new Question("As part of the plan to upgrade the Gramercy Restaurant and attract more patrons, an _______ ambience will be created by an interior decorator.",
                "(A) invite", "(B) invited", "(C) invitation", "(D) inviting", 4, Category.DAY24);
        addQuestion(q3_24);
        Question q4_24 = new Question("The new bakery on Main Street produced such _______ products that within six months time, it opened another branch to accommodate customer demands.",
                "(A) exceptional", "(B) plentiful", "(C) expensive", "(D) invaluable", 1, Category.DAY24);
        addQuestion(q4_24);
        Question q5_24 = new Question("_______ arbitration, senior management made concessions to the employees' demands, which union representatives believed to be fair and progressive.",
                "(A) Before", "(B) During", "(C) Besides", "(D) Since", 2, Category.DAY24);
        addQuestion(q5_24);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_25 = new Question("Customers who are dissatisfied with a product must furnish proof of purchase _______ file a complaint with the company.",
                "(A) in order to", "(B) prior to", "(C) inspite of", "(D) because of", 1, Category.DAY25);
        addQuestion(q1_25);
        Question q2_25 = new Question("The deadline for our feasibility study is unattainable, _______ the financial data we received was inaccurate and needs to be corrected.",
                "(A) since", "(B) once", "(C) despite", "(D) regardless of", 1, Category.DAY25);
        addQuestion(q2_25);
        Question q3_25 = new Question("The Gibson Hotel is rather _______ with regard to its proximity to the airport, but the lack of fine dining establishments in the area is bothersome to hotel guests.",
                "(A) convenient", "(B) supportive", "(C) relative", "(D) spacious", 1, Category.DAY25);
        addQuestion(q3_25);
        Question q4_25 = new Question("_______ the city government has limited funds, it displayed expensive decorations during this year’s Winter Festival.",
                "(A) Whenever", "(B) As though", "(C) Although", "(D) Now that", 3, Category.DAY25);
        addQuestion(q4_25);
        Question q5_25 = new Question("The Nutcracker commemorative items _______ in the theatre lobby after the show.",
                "(A) will have been selling", "(B) will be selling", "(C) will be sold", "(D) will have been sold", 3, Category.DAY25);
        addQuestion(q5_25);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_26 = new Question("During the orientation, the personnel department chief told the newly hired flight attendants to expect a _______ future with Andromeda Airlines.",
                "(A) promise", "(B) promising", "(C) promised", "(D) promises", 2, Category.DAY26);
        addQuestion(q1_26);
        Question q2_26 = new Question("As a matter of policy, we expedite delivery of all online orders, which will be _______ directly from the warehouse closest to your location.",
                "(A) shipped", "(B) followed", "(C) inventoried", "(D) entrusted", 1, Category.DAY26);
        addQuestion(q2_26);
        Question q3_26 = new Question("To receive credit for the fieldwork _______ for political science courses, students must satisfy a total of 12 hours when doing their internship.",
                "(A) require", "(B) requiring", "(C) requires", "(D) requirement", 4, Category.DAY26);
        addQuestion(q3_26);
        Question q4_26 = new Question("Workshop participants are reminded not to leave the building during the morning _______ so as not to miss the next presentation, which will begin in 10 minutes.",
                "(A) slot", "(B) break", "(C) rush", "(D) incident", 2, Category.DAY26);
        addQuestion(q4_26);
        Question q5_26 = new Question("_______ the city government has limited funds, it displayed expensive decorations during this year’s Winter Festival.",
                "(A) Without", "(B) Despite", "(C) Although", "(D) Now that", 3, Category.DAY26);
        addQuestion(q5_26);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_27 = new Question("Immediately following the conclusion of the performance, commemorative items for the Nutcracker _______ in the theatre lobby.",
                "(A) will be sold", "(B) will be selling", "(C) will have been selling", "(D) will have been sold", 1, Category.DAY27);
        addQuestion(q1_27);
        Question q2_27 = new Question("During the orientation, the personnel department chief told the newly hired flight attendants to expect a _______ future with Andromeda Airlines.",
                "(A) promising", "(B) pressing", "(C) comforting", "(D) repeating", 1, Category.DAY27);
        addQuestion(q2_27);
        Question q3_27 = new Question("As part of our promotion, a free bottle of wine and cheese will be brought to the guest's room _______ any 2-night stay at the hotel during the month of April.",
                "(A) to", "(B) by", "(C) on", "(D) at", 3, Category.DAY27);
        addQuestion(q3_27);
        Question q4_27 = new Question("The client will be very _______ to know that the terms he requested were approved by management, and the contract will be delivered before noon.",
                "(A) pleasant", "(B) pleasing", "(C) pleased", "(D) please", 3, Category.DAY27);
        addQuestion(q4_27);
        Question q5_27 = new Question("The factory supervisors are confident that the skilled workers will be able to _______ any equipment problems they experience on the assembly line.",
                "(A) challenge", "(B) attempt", "(C) address", "(D) submit", 3, Category.DAY27);
        addQuestion(q5_27);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_28 = new Question("_______ the country’s Independence Day, Omega Broadcasting Network will air a series of documentaries about our national heroes.",
                "(A) Will celebrate", "(B) To celebrate", "(C) Celebrates", "(D) Celebrated", 2, Category.DAY28);
        addQuestion(q1_28);
        Question q2_28 = new Question("The _______ of the consumer survey, which was conducted last week, is scheduled to be finalized this month.",
                "(A) analyzing", "(B) analyzed", "(C) analyst", "(D) analysis", 4, Category.DAY28);
        addQuestion(q2_28);
        Question q3_28 = new Question("Questions _______ the merger of Digital Works and Silver-Print Company will be addressed at a press conference at the Middleton Hotel media room at 1 P.M.",
                "(A) notwithstanding", "(B) concerning", "(C) excluding", "(D) considering", 2, Category.DAY28);
        addQuestion(q3_28);
        Question q4_28 = new Question("An organization of highly successful entrepreneurs has sponsored a franchise fair _______ clothing stores and pastry shops.",
                "(A) featuring", "(B) demonstrating", "(C) organizing", "(D) entering", 1, Category.DAY28);
        addQuestion(q4_28);
        Question q5_28 = new Question("_______ suites at Roxton Silverline Apartments are still available except the one on the 50th floor, which is reserved for Ms. Diggins’ family.",
                "(A) Each", "(B) Every", "(C) All", "(D) Much", 3, Category.DAY28);
        addQuestion(q5_28);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_29 = new Question("Power Blast helps the body recover energy as it _______ restores minerals and body fluids lost through physical exertion.",
                "(A) adventurously", "(B) importantly", "(C) rapidly", "(D) loudly", 3, Category.DAY29);
        addQuestion(q1_29);
        Question q2_29 = new Question("The purpose of the meeting tomorrow is to go over the revised terms of the contract and ensure that its new stipulations are _______ to the client.",
                "(A) outright", "(B) agreeable", "(C) responsive", "(D) sympathetic", 2, Category.DAY29);
        addQuestion(q2_29);
        Question q3_29 = new Question("When _______ stains from a delicate fabric, use a mild soap instead of a powerful bleach, which can quickly destroy the fibers of the material.",
                "(A) remove", "(B) removal", "(C) removing", "(D) removed", 3, Category.DAY29);
        addQuestion(q3_29);
        Question q4_29 = new Question("Employees who would like to assist the victims of the storm are requested to _______ directly to the calamity fund or volunteer in the clean-up work.",
                "(A) distribute", "(B) donate", "(C) reserve", "(D) approve", 2, Category.DAY29);
        addQuestion(q4_29);
        Question q5_29 = new Question("Bien Castro requested to have all his mail _______ to his office because he rooms in a dormitory on weekdays and returns home only at the end of the workweek.",
                "(A) deliver", "(B) delivering", "(C) delivered", "(D) to deliver", 3, Category.DAY29);
        addQuestion(q5_29);
        ////////////////////////////////////////////////////////////////////////////////////////////
        Question q1_30 = new Question("Please _______ a recent identification card with a picture or a valid passport when applying for documents and services at government offices.",
                "(A) present", "(B) reveal", "(C) maintain", "(D) confer", 1, Category.DAY30);
        addQuestion(q1_30);
        Question q2_30 = new Question("In a letter that was published by a popular newspaper, a reader wrote _______ about the need for more funding to assist local charities and help organizations.",
                "(A) briskly", "(B) expressly", "(C) exceptionally", "(D) differently", 2, Category.DAY30);
        addQuestion(q2_30);
        Question q3_30 = new Question("Since its formation in 1993, the Youth Employment Center has provided _______ to out-of-school youth in education and career planning.",
                "(A) assisted", "(B) assistance", "(C) assisting", "(D) assistant", 2, Category.DAY30);
        addQuestion(q3_30);
        Question q4_30 = new Question("At top-rated restaurants, cooks constantly _______ the dishes they prepare to ensure that they are perfect before being served to customers.",
                "(A) dispose", "(B) taste", "(C) swallow", "(D) absorb", 2, Category.DAY30);
        addQuestion(q4_30);
        Question q5_30 = new Question("Only recently did Digital Age’s board _______ discussing the possibility of forming affiliations with smaller manufacturers of electronic devices.",
                "(A) began", "(B) beginning", "(C) begin", "(D) to begin", 3, Category.DAY30);
        addQuestion(q5_30);
        ////////////////////////////////////////////////////////////////////////////////////////////
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    @SuppressLint("Range")
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
            } while (c.moveToNext());
        }

        c.close();
        return categoryList;
    }

    @SuppressLint("Range")
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
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    @SuppressLint("Range")
    public ArrayList<Question> getQuestions(int categoryID) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = QuestionsTable.COLUMN_CATEGORY_ID + " = ? ";
        String[] selectionArgs = new String[] {String.valueOf(categoryID)};

        Cursor c= db.query(
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
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}