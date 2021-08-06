import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private VBox inputLabel;
    @FXML
    private VBox inputInsertArea;
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputAge;
    @FXML
    private ChoiceBox<String> inputGender;
    @FXML
    private TextField inputHeight;
    @FXML
    private TextField inputWeight;
    @FXML
    private Button result;
    @FXML
    private TextField BMIResult;
    @FXML
    private TextField BFPResult;
    @FXML
    private TextField LBMResult;
    @FXML
    private TextField BMRResult;
    @FXML
    private TextField RWLResult;
    @FXML
    private Button nextButton;

    private String name;
    private int age;
    private double height;
    private double weight;
    private String gender;
    private double BMI;
    private double BFP;
    private double constant1;
    private double LBM;
    private double BMR;
    private double RWL;




    @FXML
    public void calculate(ActionEvent event) throws Exception {

        name = inputName.getText();
        age = Integer.parseInt(inputAge.getText());
        height = Double.parseDouble(inputHeight.getText());
        weight = Double.parseDouble(inputWeight.getText());
        String chosenGender = getGender(event);

        BMI = weight / ((height / 100) * (height / 100));
        String bmi = String.format("%.2f",BMI);
        BMIResult.setText(bmi);

        if(chosenGender == "Male"){
            constant1 = 16.2;
        }
        else {
            constant1 = 5.4;
        }

        BFP = ( 1.2 * BMI ) + ( 0.23 * age ) - constant1;
        String bfp = String.format("%.2f",BFP);
        BFPResult.setText(bfp);

        LBM = weight*(1-(BFP/100));
        String lbm = String.format("%.2f",LBM);
        LBMResult.setText(lbm);

        BMR = 370 + 21.6 * LBM;
        String bmr = String.format("%.2f",BMR);
        BMRResult.setText(bmr);

        RWL = ((BFP/100)/20) * weight;
        String rwl = String.format("%.2f",RWL);
        RWLResult.setText(rwl);


        System.out.println(name + "\n" + age + "\n" + height + "\n" + weight + "\n" + chosenGender + BMI);
        System.out.println(BFP + "\n" + LBM + "\n" + BMR);

    }

    @FXML
    public void switchtoScene2 (ActionEvent event){

        try {
            double aveBMR = Double.parseDouble(BMRResult.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
            root = loader.load();

            Scene2Controller scene2Controller = loader.getController();
            scene2Controller.avgBMR(aveBMR);

            //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            }
        catch (Exception e){
            System.out.println(e);
            }

        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String[] genderList = {"Male","Female"};
        inputGender.getItems().addAll(genderList);
        inputGender.setOnAction(this ::getGender);

    }

    public String getGender(ActionEvent event){

        gender = inputGender.getValue();
        return gender;

    }

}
