package cleanTest;

import activity.whenDo.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class CrudNoteWhenDoTest {
    MainScreen mainScreen = new MainScreen();
    CreateNoteForm createNoteForm = new CreateNoteForm();
    UpdateNoteForm updateNoteForm = new UpdateNoteForm();
    DeleteNoteForm deleteNoteForm = new DeleteNoteForm();
    ConfirmationDeleteModal confirmationDeleteModal = new ConfirmationDeleteModal();

    @Test
    public void verifyCreateNewNote(){
        String title="Cato";
        String note="esta es una nota";

        mainScreen.addNoteButton.click();
        createNoteForm.titleTxtBox.setText(title);
        createNoteForm.noteTxtBox.setText(note);
        createNoteForm.saveButton.click();

        Assertions.assertTrue(mainScreen.isNoteDisplayed(title),
                "ERROR, the note was not created");

    }
    @Test
    public void verifyUpdateNote(){
        String title="notaprueba";
        String note="esta es una nota";

        String titleUpdate="notaprueba actualizado";
        String noteUpdate="esta es una nota actualizada";

        mainScreen.addNoteButton.click();
        createNoteForm.titleTxtBox.setText(title);
        createNoteForm.noteTxtBox.setText(note);
        createNoteForm.saveButton.click();
        mainScreen.isNoteDisplayed(title);
        mainScreen.NoteDisplayed(title).click();
        updateNoteForm.titleTxtBox.setText(titleUpdate);
        updateNoteForm.noteTxtBox.setText(noteUpdate);
        updateNoteForm.saveButton.click();

        Assertions.assertTrue(mainScreen.isNoteDisplayed(titleUpdate),
                "ERROR, the note is update");
    }
    @Test
    public void verifyDeleteNote(){
        String title="notaprueba";
        String note="esta es una nota";

        mainScreen.addNoteButton.click();
        createNoteForm.titleTxtBox.setText(title);
        createNoteForm.noteTxtBox.setText(note);
        createNoteForm.saveButton.click();
        mainScreen.isNoteDisplayed(title);
        mainScreen.NoteDisplayed(title).click();
        deleteNoteForm.deleteButton.click();
        confirmationDeleteModal.deleteButton.click();
        Assertions.assertFalse(mainScreen.isNoteDisplayed(title),
                "ERROR, the note is update");
    }
    @AfterEach
    public void closeApp(){
        Session.getInstance().closeApp();
    }

}
