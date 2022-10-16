package activity.whenDo;

import appiumControl.Button;
import appiumControl.Label;
import appiumControl.TextBox;
import org.openqa.selenium.By;

public class ConfirmationDeleteModal {
    public Label titleModal= new Label(By.id("com.vrproductiveapps.whendo:id/title_template"));
    public Button deleteButton = new Button(By.id("android:id/button1"));
    public Button CancelButton = new Button(By.id("android:id/button2"));

}
