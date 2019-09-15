package bookdatabase.EmployeePage;

import bookdatabase.Books;
import bookdatabase.StudentPage.StudentPageFXMLController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * @author Pramod
 * @modifier Vinayak, Kiranjit
 */
public class EmployeePageFXMLController implements Initializable {

    @FXML
    private Button btnLogout, btnAdd, btnDelete, btnRefresh, btnClear, btnEmployeePageExit, btnGo;

    @FXML
    private ListView lstEmployeeBookList;

    @FXML
    private ComboBox cmbView;

    @FXML
    private TextField txtISBN, txtTitle, txtAuthor, txtCategory, txtEdition, txtGo;

    private final ObservableList<String> obsBookList = FXCollections.observableArrayList();
    private final ObservableList<Books> obsEmptyList = FXCollections.observableArrayList();
    private final ObservableList<String> obsFilterList = FXCollections.observableArrayList();
    private final ObservableList<String> obsFilterSearchList = FXCollections.observableArrayList();

    int ISBN = 0, edition = 0, record_number;
    String title, author, category;
    boolean repeat = true;

    List<Books> bookList = new ArrayList<Books>();
    List<Books> filterBookList = new ArrayList<Books>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        obsFilterList.add("ISBN");
        obsFilterList.add("Title");
        obsFilterList.add("Author");
        obsFilterList.add("Edition");
        obsFilterList.add("Category");

        cmbView.setItems(obsFilterList);

        btnLogout.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPageFXMLDocument.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setTitle("Employee Page");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                System.out.println("Logout on Employee Page not working");
            }
        });

        lstEmployeeBookList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                int item = lstEmployeeBookList.getSelectionModel().getSelectedIndex();
                System.out.println("Selected record is: " + item + 1);
            }
        });

        btnAdd.setOnAction((ActionEvent event) -> {
            try {
//                Books book = new Books();
//
//                book.setISBN(Integer.parseInt(txtISBN.getText()));
//                book.setTitle(txtTitle.getText());
//                book.setAuthor(txtAuthor.getText());
//                book.setEdition(Integer.parseInt(txtEdition.getText()));
//                book.setCategory(txtCategory.getText());
//
//                obsBookList.add(book);
//
//                lstEmployeeBookList.setItems(obsEmptyList);
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                System.out.println("Add books(Employee) - not working");
//            }
//        });

// Code for RAF
                RandomAccessFile raf = new RandomAccessFile(new File("test.txt"), "rw");

                int TITLE_SIZE = 40;
                int AUTHOR_SIZE = 30;
                int CATEGORY_SIZE = 20;

                String title = txtTitle.getText();
                String author = txtAuthor.getText();
                String category = txtCategory.getText();

                title = title.trim();
                author = author.trim();
                category = category.trim();

                if (title.length() < TITLE_SIZE) {
                    for (int i = title.length(); i < TITLE_SIZE; i++) {
                        title = title + " ";
                    }
                    System.out.println("Length is: " + title.length());
                }

                if (author.length() < AUTHOR_SIZE) {
                    for (int i = author.length(); i < AUTHOR_SIZE; i++) {
                        author = author + " ";
                    }
                    System.out.println("Length is: " + author.length());
                }

                if (category.length() < CATEGORY_SIZE) {
                    for (int i = category.length(); i < CATEGORY_SIZE; i++) {
                        category = category + " ";
                    }
                    System.out.println("Length is:lt " + category.length());
                }

                if (title.length() > TITLE_SIZE) {
//                    for (int i = title.length(); i > TITLE_SIZE; i--) {
//                        title = title.substring(0, title.length() - 2);
//                    }
                    title = title.substring(0, 40);
                    System.out.println("Length is:gt " + title.length());
                }

                if (author.length() > AUTHOR_SIZE) {
//                    for (int i = author.length(); i > AUTHOR_SIZE; i--) {
//                        author = author.substring(0, author.length() - 2);
//                    }
                    author = author.substring(0, 30);
                    System.out.println("Length is:gt " + author.length());
                }

                if (category.length() > CATEGORY_SIZE) {
//                    for (int i = category.length(); i > CATEGORY_SIZE; i--) {
//                        category = category.substring(0, category.length() - 2);
//                    }
                    category = category.substring(0, 20);
                    System.out.println("Length is:gt " + category.length());
                }

                if ((title.length() == TITLE_SIZE) && (author.length() == AUTHOR_SIZE) && (category.length() == CATEGORY_SIZE)) {
                    raf.seek(raf.length());
                    raf.writeInt(Integer.parseInt(txtISBN.getText()));
                    System.out.println("Size of file after ISBN is " + raf.length());
                    raf.writeChars(title);
                    System.out.println("Size of file after Title is " + raf.length());
                    raf.writeChars(author);
                    System.out.println("Size of file after Author is " + raf.length());
                    raf.writeInt(Integer.parseInt(txtEdition.getText()));
                    System.out.println("Size of file after Edition is " + raf.length());
                    raf.writeChars(category);
                    System.out.println("Size of file after Category is " + raf.length());
//                    System.out.println("Length is: " + title.length());
//                    System.out.println("Length is: " + author.length());
//                    System.out.println("Length is: " + category.length());
                    raf.close();
                }

            } catch (FileNotFoundException ex) {
//            Logger.getLogger(EmployeePageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
            } catch (IOException ex) {
                Logger.getLogger(EmployeePageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // TODO
        btnGo.setOnAction((ActionEvent event) -> {

            try {
                String selection = cmbView.getSelectionModel().getSelectedItem().toString();
                String search_term = txtGo.getText();

                RandomAccessFile raf = new RandomAccessFile(new File("test.txt"), "r");

                int num_records = (int) (raf.length() / 188);
                System.out.println("num records is " + num_records);

                int loc = 0;

                switch (selection) {
                    case "ISBN": {
                        lstEmployeeBookList.setItems(obsEmptyList);
                        raf.seek(loc);

                        for (int j = 0; j < num_records; j++) {
                            String record_value = "" + raf.readInt();
                            System.out.println("Record value:" + record_value);
                            System.out.println("Search term:" + search_term);
                            if (search_term.equals(record_value)) {
                                System.out.println("Found");
                                raf.seek(loc);
                                ISBN = raf.readInt();
                                loc = loc + 4;
                                System.out.println("Loc after ISBN is " + loc);

                                raf.seek(loc);
                                String n = "";
                                for (int i = 0; i < 40; i++) {
                                    n += String.valueOf(raf.readChar());
                                }
                                System.out.println(n);
                                title = n;
                                loc = loc + 80;
                                System.out.println("Loc after title is " + loc);

                                raf.seek(loc);
                                String n1 = "";
                                for (int i = 0; i < 30; i++) {
                                    n1 += String.valueOf(raf.readChar());
                                }
                                System.out.println(n1);
                                author = n1;
                                loc = loc + 60;
                                System.out.println("Loc after author is " + loc);

                                raf.seek(loc);
                                edition = raf.readInt();
                                loc = loc + 4;
                                System.out.println("Loc after edition is " + loc);

                                raf.seek(loc);
                                String n2 = "";
                                for (int i = 0; i < 20; i++) {
                                    n2 += String.valueOf(raf.readChar());
                                }
                                System.out.println(n2);
                                category = n2;
                                loc = loc + 40;
                                System.out.println("Loc after category is " + loc);

                                filterBookList.clear();
                                filterBookList.add(new Books(ISBN, title, author, edition, category));
                                obsFilterSearchList.clear();
                                obsFilterSearchList.add(filterBookList.get(0).toString());
                                repeat = true;
                                lstEmployeeBookList.setItems(obsFilterSearchList);
                                break;
                            }
                            System.out.println("Location after reading record " + j + " is " + loc);
                            loc = loc + 188;
                            raf.seek(loc);
                            System.out.println("Updated location is " + loc);
                        }
                    }
                    break;
                    case "Title": {
                        break;
                    }
                    case "Author": {
                        break;
                    }
                    case "Edition": {
                        break;
                    }
                    case "Category": {
                        break;
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentPageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StudentPageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Go(Employee) - not working");
            }
        });

        btnRefresh.setOnAction((ActionEvent event) -> {
            repeat = true;
            try {
                //lstEmployeeBookList.setItems(obsBookList);

// Code for reading from RAF into observable list
                if (repeat) {
                    obsBookList.clear();
                    bookList.clear();

                    RandomAccessFile raf = new RandomAccessFile(new File("test.txt"), "r");

                    System.out.println("Length: " + raf.length());
                    int num_records = (int) (raf.length() / 188);
                    System.out.println("num records is " + num_records);

                    int loc = 0;

                    while (loc < raf.length()) {
                        raf.seek(loc);
                        ISBN = raf.readInt();
                        loc = loc + 4;
                        System.out.println("Loc after ISBN is " + loc);

                        raf.seek(loc);
                        String n = "";
                        for (int i = 0; i < 40; i++) {
                            n += String.valueOf(raf.readChar());
                        }
                        System.out.println(n);
                        title = n;
                        loc = loc + 80;
                        System.out.println("Loc after title is " + loc);

                        raf.seek(loc);
                        String n1 = "";
                        for (int i = 0; i < 30; i++) {
                            n1 += String.valueOf(raf.readChar());
                        }
                        System.out.println(n1);
                        author = n1;
                        loc = loc + 60;
                        System.out.println("Loc after author is " + loc);

                        raf.seek(loc);
                        edition = raf.readInt();
                        loc = loc + 4;
                        System.out.println("Loc after edition is " + loc);

                        raf.seek(loc);
                        String n2 = "";
                        for (int i = 0; i < 20; i++) {
                            n2 += String.valueOf(raf.readChar());
                        }
                        System.out.println(n2);
                        category = n2;
                        loc = loc + 40;
                        System.out.println("Loc after category is " + loc);

                        bookList.add(new Books(ISBN, title, author, edition, category));
                    }

                    for (int i = 0; i <= bookList.size() - 1; i++) {

                        obsBookList.add(bookList.get(i).toString());
                    }
                    lstEmployeeBookList.setItems(obsBookList);
                    repeat = false;
                } else {
                    repeat = false;
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentPageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StudentPageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Refresh books(Employee) - not working");
            }
        });

        btnClear.setOnAction((ActionEvent event) -> {
            try {
                txtISBN.setText("");
                txtTitle.setText("");
                txtEdition.setText("");
                txtCategory.setText("");
                txtAuthor.setText("");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Clear books(Employee) - not working");
            }
        });

        btnDelete.setOnAction((ActionEvent event) -> {
            try {
                obsBookList.remove(lstEmployeeBookList.getSelectionModel().getSelectedItem());
                record_number = lstEmployeeBookList.getSelectionModel().getSelectedIndex();

                RandomAccessFile raf = new RandomAccessFile(new File("test.txt"), "rw");

                int loc = record_number * 188;
                raf.seek(loc);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Remove books(Employee) - not working");
            }
        });

        btnEmployeePageExit.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setX(500);
            alert.setY(350);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Exit Application");
            alert.setContentText("Are you sure you want to quit?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.exit(0);
            }
        });

    }

    private void delete(int record_number) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("test.txt"), "r");
        RandomAccessFile raf1 = new RandomAccessFile(new File("test1.txt"), "rw");
        int loc = 0;
        lstEmployeeBookList.getSelectionModel().selectedItemProperty().addListener((ObservableValue observable, Object oldValue, Object newValue) -> {
            int item = lstEmployeeBookList.getSelectionModel().getSelectedIndex();
            System.out.println("Selected record is: " + item + 1);
        });
        raf.seek(lstEmployeeBookList.getSelectionModel().getSelectedIndex() * 188);
    }

}
