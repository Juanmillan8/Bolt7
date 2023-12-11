package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class IntroducirDatos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfTarjeta;
	private JTextField tfMotivo;
	private ButtonGroup bg = new ButtonGroup();
	private JLabel lblError;


	/**
	 * Create the dialog.
	 */
	public IntroducirDatos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IntroducirDatos.class.getResource("/imagenes/iconoAplicacion.png")));
		setBounds(100, 100, 507, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		//jtextfield tfTarjeta usada para introducir el numero de tarjeta sanitaria del usuario
		tfTarjeta = new JTextField();
		tfTarjeta.setToolTipText("Introduce tu numero de tarjeta sanitaria");
		tfTarjeta.setBounds(10, 71, 202, 25);
		contentPanel.add(tfTarjeta);
		tfTarjeta.setColumns(10);
		
		//jradiobutton rbMatrona
		JRadioButton rbMatrona = new JRadioButton("Matrona");
		rbMatrona.setToolTipText("Seleccione una de las opciones");
		rbMatrona.setForeground(new Color(0, 0, 0));
		rbMatrona.setBackground(new Color(255, 255, 255));
		rbMatrona.setBounds(376, 92, 109, 23);
		contentPanel.add(rbMatrona);
		
		//jradiobutton rbTest
		JRadioButton rbTest = new JRadioButton("Test antigenos");
		rbTest.setToolTipText("Seleccione una de las opciones");
		rbTest.setBackground(new Color(255, 255, 255));
		rbTest.setForeground(new Color(0, 0, 0));
		rbTest.setBounds(376, 118, 109, 23);
		contentPanel.add(rbTest);
		
		//jradiobutton rbEnfermeria
		JRadioButton rbEnfermeria = new JRadioButton("Enfermería");
		rbEnfermeria.setToolTipText("Seleccione una de las opciones");
		rbEnfermeria.setBackground(new Color(255, 255, 255));
		rbEnfermeria.setForeground(new Color(0, 0, 0));
		rbEnfermeria.setBounds(376, 144, 109, 23);
		contentPanel.add(rbEnfermeria);
		
		//buttongroup en el que introduciremos los radiobutton vistos anteriormente
		bg.add(rbMatrona);
		bg.add(rbTest);
		bg.add(rbEnfermeria);
		
		
		//jlabel lblTarjeta, aqui indicamos al usuario donde debe insertar el numero de su tarjeta sanitaria
		JLabel lblTarjeta = new JLabel("Nº de tarjeta sanitaria:");
		lblTarjeta.setBackground(new Color(255, 255, 255));
		lblTarjeta.setForeground(new Color(0, 0, 0));
		lblTarjeta.setBounds(10, 46, 156, 14);
		contentPanel.add(lblTarjeta);
		
		//jtextfield tfMotivo, en este campo de texto el usuario debe insertar el motivo de su cita
		tfMotivo = new JTextField();
		tfMotivo.setToolTipText("Explica el motivo o problema por el que desea realizar la consulta");
		tfMotivo.setColumns(10);
		tfMotivo.setBounds(10, 161, 202, 25);
		contentPanel.add(tfMotivo);
		
		//jlabel lblMotivo, aqui indicamos al usuario donde debe insertar el motivo de su consulta
		JLabel lblMotivo = new JLabel("Motivo de la consulta:");
		lblMotivo.setForeground(new Color(0, 0, 0));
		lblMotivo.setBounds(10, 136, 156, 14);
		contentPanel.add(lblMotivo);
		
		//jlabel lblProfesional, aqui indicamos al usuario el profesional a elejir para su consulta
		JLabel lblProfesional = new JLabel("Profesional");
		lblProfesional.setForeground(new Color(255, 255, 255));
		lblProfesional.setBounds(379, 71, 86, 14);
		contentPanel.add(lblProfesional);
		
		
			//jpanel buttonPane, aqui es donde ira el boton para confirmar todos los datos
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(51, 153, 153));
			buttonPane.setBounds(0, 228, 491, 33);
			contentPanel.add(buttonPane);
			{
				//jbutton btnAceptar
				JButton btnAceptar = new JButton("OK");
				btnAceptar.setToolTipText("Guarda los datos de la cita");
				btnAceptar.setBackground(new Color(51, 153, 153));
				btnAceptar.setForeground(new Color(255, 255, 255));
				btnAceptar.setBounds(405, 5, 76, 23);
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					//Si pulsamos este boton pero no hemos insertado nada en los campos de texto usaremos el jlabel lbError para mostrar un 
					//mensaje de error
					if (tfTarjeta.getText().length()==0 | tfMotivo.getText().length()==0) {
						
						lblError.setText("ERROR, debes rellenar los campos de texto");
					
						//Mensaje de prueba unitaria
						System.err.println("ERROR, los campos de texto no han sido rellenados");
						
					//Y si no hemos elejido ningun profesional mostraremos otro mensaje de error
					}else if (!rbMatrona.isSelected() && !rbTest.isSelected() && !rbEnfermeria.isSelected()) {
						
						lblError.setText("ERROR, debes seleccionar el tipo de profesional");
						
						//Mensaje de prueba unitaria
						System.err.println("ERROR, no se ha seleccionado ningun radioButton");
						
					}else {
						
						//Mensaje de prueba unitaria
						System.out.println("\u001B[32mSe ha rellenado toda la informacion correctamente\u001B[0m");
						  
						
						
						//String profesional para almacenar el profesional que hemos elejido 
						String profesional;
						
						//Si el radiobutton tbMatrona ha sido seleccionado insertamos el texto matrona en el String profesional
						if (rbMatrona.isSelected()) {
							
							profesional="matrona";
						
						//En cambio si hemos seleccionado el radiobutton rbTest insertamos el texto text antigenos en el String profesional
						}else if (rbTest.isSelected()) {
							
							profesional="test antigenos";
						
						//Si no hemos seleccionado ningun radiobutton de los anteriores nos queda el rbEnfermeria, insertamos en el String 
						//profesional el texto enfermeria
						}else {
							
							profesional="enfermeria";
							
							
						}
						
						
						
						
						//Posteriormente volvemos a la ventana PrimeraVentana y le pasamos a traves del String informacion de dicha ventana
						//toda la informacion que acabamos de configurar 
						PrimeraVentana pm = new PrimeraVentana();
						pm.setLocationRelativeTo(null);
						pm.setVisible(true);
						pm.informacion=("<html>el usuario con tarjeta sanitaria " + tfTarjeta.getText() + " ha configurado una cita "
								+ "con motivo: \"" + tfMotivo.getText() + "\"   y profesional " + profesional + " </html>");
						
						dispose();
						
					}
						
						
					}
				});
				buttonPane.setLayout(null);
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			
			//jlabel lblError, que al principio estara invisible asta que ocurra algun error, como por ejemplo hacer click en el boton btnAceptar sin haber
			//insertado datos
			lblError = new JLabel("");
			lblError.setBounds(106, 197, 313, 25);
			contentPanel.add(lblError);
			lblError.setForeground(new Color(255, 0, 0));
			lblError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
	}
