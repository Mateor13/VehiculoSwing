import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form2 extends JFrame {
    private JTextField pl;
    private JPanel panel2;
    private JButton buscarButton;
    private JButton regresarButton;
    private JLabel placa;
    private JLabel marca;
    private JLabel cilindraje;
    private JLabel Combusti;
    private JLabel colo;
    private JLabel propi;
    private JButton borrarButton;

    public form2() {
        setTitle("Buscar Vehículo");
        setContentPane(panel2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 250));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        borrarButton.setVisible(false);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/conce";
                String user = "root";
                String pass = "123456";
                vehiculos veh = new vehiculos();
                veh.setPlaca(pl.getText());
                String querry = "select * from vehiculos where placa = '"+veh.getPlaca()+"'";
                try (Connection con = DriverManager.getConnection(url, user, pass)){
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(querry);
                    if (rs.next()) {
                        placa.setText("Placa: "+rs.getString("placa"));
                        marca.setText("Marca: "+rs.getString("marca"));
                        cilindraje.setText("Cilindraje: "+rs.getString("cilindraje"));
                        Combusti.setText("Tipo de combustible: "+rs.getString("tipoCombustible"));
                        colo.setText("Color: "+ rs.getString("color"));
                        propi.setText("Propietario: "+rs.getString("propietario"));
                        borrarButton.setVisible(true);
                        setPreferredSize(new Dimension(600, 400));
                        pack();
                        setLocationRelativeTo(null);
                    }else{
                        propi.setText("No se encontró el vehículo");
                    }
                }catch(SQLException e1){
                    e1.printStackTrace();
                    propi.setText("Error en la base de datos");
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new menu();
                dispose();
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pl.setText("");
                placa.setText("");
                marca.setText("");
                cilindraje.setText("");
                Combusti.setText("");
                colo.setText("");
                propi.setText("");
                borrarButton.setVisible(false);
                setPreferredSize(new Dimension(600, 250));
                pack();
                setLocationRelativeTo(null);
            }
        });
    }
}
