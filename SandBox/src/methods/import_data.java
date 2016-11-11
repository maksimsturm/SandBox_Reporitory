package methods;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;
import java.util.Random;

public class import_data {
    Connection connection = null;
    //url для подключения
    String url = "jdbc:postgresql://54.76.42.99:15432/usersdb";
    //Логин
    String name = "postgres";
    //Пароль
    String password = "postgres";




    public void import_sql() throws Exception {
        //Подключаем драйвер
        Class.forName("org.postgresql.Driver");
        System.out.println("Драйвер подключен");
        //Подключаемся
        connection = DriverManager.getConnection(url, name, password);
        System.out.println("Соединение с базой");
        //Переменные

        UUID userid = UUID.randomUUID();
        UUID authtoken = UUID.randomUUID();
        UUID orgoid = UUID.randomUUID();
        String username = "Bu123123";
        String firstname = "Владимир1";
        String lastname = "Петров12";
        String middlename = "Ива11нови213ч";
        String fullorgname = "Глав12Бург213ер";
        String shortorgname = "Глав1Бур123гер";
        String orgtype = "L";
        //

        //Рандомное значение КПП
        StringBuilder kpp=new StringBuilder();
        Random kppr = new Random();
        for (int i=0;i<9;i++){
            Integer t=(int)(Math.random()*10);
            kpp.append(t);
        }
        //Рандомное значение ОГРН
        StringBuilder ogrn=new StringBuilder();
        Random ogrnr = new Random();
        for (int i=0;i<15;i++){
            Integer t=(int)(Math.random()*10);
            ogrn.append(t);
        }
        //ИНН
        int innrand=12;
        //Рандомное значение ИНН
        StringBuilder inn=new StringBuilder();
        Random innr = new Random();
        for (int i=0;i<innrand;i++){
            Integer t=(int)(Math.random()*10);
            inn.append(t);
        }

        //Выполняем запрос
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(
                "INSERT INTO users.esia_users\n" +
                        "(userid, username, firstname, lastname, middlename, personinn, personsnils, personogrn, personemail, authnmethod, authtoken, persontype, globalrole, memberofgroups, orgaddresses, orgcontacts, orgoid, orgkpp, orglegalform, orginn, orgname, orgshortname, orgogrn, orgposition, orgtype, password, gender, birthdate)\n" +
                        "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, ?, ?, '<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><orgaddresses><address><addresstype>ORG_POSTAL</addresstype><contrychar3code>RUS</contrychar3code><index>300041</index><region>Тульская Область</region><district>г. Тула, ул. Вересаева</district><house>2</house><corpus></corpus><structure></structure><flat>1</flat></address><address><addresstype>ORG_LEGAL</addresstype><contrychar3code>RUS</contrychar3code><index>300041</index><kladrcode>7100000100003310004</kladrcode><russianregioncode>71</russianregioncode><region>Тульская обл.</region><district></district><settlement>г. Тула</settlement><street>ул. Вересаева</street><house>2</house><corpus></corpus><structure></structure><flat></flat></address></orgaddresses>', '<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><orgcontacts><contact><contacttype>PHN</contacttype><value>+7(872)563432</value><verificationstatus>N</verificationstatus></contact><contact><contacttype>EML</contacttype><value>ukpartner@list.ru</value><verificationstatus>N</verificationstatus></contact></orgcontacts>', ?, ?, 'Закрытые акционерные общества', ?, ?, ?, ?, 'Специалист', ?, 'RuRKoLwh2Kgm15NE3zi+Sw==', 'MALE', '01-01-1984')");
        preparedStatement.setString(1, String.valueOf(userid));
        preparedStatement.setString(2, String.valueOf(username));
        preparedStatement.setString(3, String.valueOf(firstname));
        preparedStatement.setString(4, String.valueOf(lastname));
        preparedStatement.setString(5, String.valueOf(middlename));
        preparedStatement.setString(6, "NULL");
        preparedStatement.setString(7, "NULL");
        preparedStatement.setString(8, "NULL");
        preparedStatement.setString(9, "sds@mail.com");
        preparedStatement.setString(10, "DS");
        preparedStatement.setString(11, String.valueOf(authtoken));
        preparedStatement.setString(12, "E");
        preparedStatement.setString(13, "ADMIN, AUTHORIZED_SPECIALIST");
        preparedStatement.setString(14, String.valueOf(orgoid));
        preparedStatement.setString(15, String.valueOf(kpp));
        preparedStatement.setString(16, String.valueOf(inn));
        preparedStatement.setString(17, String.valueOf(fullorgname));
        preparedStatement.setString(18, String.valueOf(shortorgname));
        preparedStatement.setString(19, String.valueOf(ogrn));
        preparedStatement.setString(20, String.valueOf(orgtype));
        preparedStatement.executeUpdate();
        System.out.println("Учётная запись и данные об организации добавлены!");
        preparedStatement = connection.prepareStatement(
                "INSERT INTO users.roles(userid, role) VALUES(?, 'ADMIN');");
        preparedStatement.setString(1, String.valueOf(userid));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO users.roles(userid, role) VALUES(?, 'AUTHORIZED_SPECIALIST');");
        preparedStatement.setString(1, String.valueOf(userid));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO users.roles(userid, role) VALUES(?, 'CITIZEN');");
        preparedStatement.setString(1, String.valueOf(userid));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO users.roles(userid, role) VALUES(?, 'ADDITIONAL_ADMIN');");
        preparedStatement.setString(1, String.valueOf(userid));
        preparedStatement.executeUpdate();
        System.out.println("Информация о ролях добавлена!");
        // Выполнение запроса
    }
}
