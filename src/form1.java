import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 extends JFrame {
    private JPanel panel1;
    private JTextField pl;
    private JTextField mrc;
    private JTextField cld;
    private JTextField comb;
    private JTextField clr;
    private JTextField prop;
    private JButton ingresarButton;
    private JButton borrarbtn;
    private JLabel resultado;
    private JButton regresarButton;

    public form1(){
        setTitle("Insertar Datos");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,520));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        borrarbtn.setVisible(false);
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pl.getText().isEmpty() || mrc.getText().isEmpty() || cld.getText().isEmpty() ||
                        comb.getText().isEmpty() || prop.getText().isEmpty() || clr.getText().isEmpty()) {
                    resultado.setText("Hay datos vacíos");
                    setPreferredSize(new Dimension(500,560));
                    pack();
                    setLocationRelativeTo(null);
                } else {
                        double cilindraje = Double.parseDouble(cld.getText());
                        vehiculos vehiculo = new vehiculos(pl.getText(), mrc.getText(), comb.getText(), clr.getText(), prop.getText(), cilindraje);

                        String url = "jdbc:mysql://localhost:3306/conce";
                        String user = "root";
                        String password = "123456";
                        String querry = "insert into vehiculos (placa, marca, tipoCombustible, cilindraje, color, propietario) values(?,?,?,?,?,?)";

                        try (Connection con = DriverManager.getConnection(url, user, password)) {
                            PreparedStatement ps = con.prepareStatement(querry);
                            ps.setString(1, vehiculo.getPlaca());
                            ps.setString(2, vehiculo.getMarca());
                            ps.setString(3, vehiculo.getTipoCombustible());
                            ps.setDouble(4, vehiculo.getCilindraje());
                            ps.setString(5, vehiculo.getColor());
                            ps.setString(6, vehiculo.getPropietario());
                            ps.executeUpdate();
                            resultado.setText("Datos insertados correctamente");
                            borrarbtn.setVisible(true);
                            setPreferredSize(new Dimension(500,560));
                            pack();
                            setLocationRelativeTo(null);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                            resultado.setText("Datos no insertados");
                            setPreferredSize(new Dimension(500,560));
                            pack();
                            setLocationRelativeTo(null);
                        }
                }
            }
        });
        borrarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pl.setText("");
                mrc.setText("");
                cld.setText("");
                comb.setText("");
                clr.setText("");
                prop.setText("");
                resultado.setText("");
                borrarbtn.setVisible(false);
                setPreferredSize(new Dimension(500,520));
                pack();
                setLocationRelativeTo(null);
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new menu();
                dispose();
            }
        });
    }
}
