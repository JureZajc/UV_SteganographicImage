import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import SteganographicImage.SteganographicImageException;

@SuppressWarnings("serial")
public class UV_test extends JFrame {
	
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnActions;
	private JButton btnStorage;
	private JTextField locationWebPhoto;
	private JTextField locationWebPhoto2;
	private JTextField locationLocal;
	private JTextField text;
//	private JTextField sizePict;
//	private JTextField attachment;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UV_test frame = new UV_test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UV_test() {
		super("UV_naloga2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 350);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(5, 2, 5, 5));
		JLabel getPhotoWeb = new JLabel("Get photo from web"); // definicija oznake
		getPhotoWeb.setHorizontalAlignment(SwingConstants.CENTER); // postavitev na sredino stolpca
		contentPane.add(getPhotoWeb); // dodajanje na plosco
		locationWebPhoto = new JTextField(); // prazno besedilno polje
		locationWebPhoto.setColumns(120); // stevilo stolpcev
		locationWebPhoto.setToolTipText("Enter direct URL to image");
		contentPane.add(locationWebPhoto); // dodajanje na plosco
		JLabel getPhotoWeb1 = new JLabel("Get another photo from web"); // definicija oznake
		getPhotoWeb1.setHorizontalAlignment(SwingConstants.CENTER); // postavitev na sredino stolpca
		contentPane.add(getPhotoWeb1); // dodajanje na plosco
		locationWebPhoto2 = new JTextField(); // prazno besedilno polje
		locationWebPhoto2.setColumns(120); // stevilo stolpcev
		locationWebPhoto2.setToolTipText("Enter direct URL to image");
		contentPane.add(locationWebPhoto2); // dodajanje na plosco
		JLabel lblDrzavaISO = new JLabel("Choose a photo localy"); // definicija oznake
		lblDrzavaISO.setHorizontalAlignment(SwingConstants.CENTER); // postavitev na sredino stolpca
		contentPane.add(lblDrzavaISO); // dodajanje na plosco	
		locationLocal = new JTextField(); // prazno besedilno polje
		locationLocal.setColumns(80); // stevilo stolpcev
		locationLocal.setToolTipText("Enter absolute path to image");
		contentPane.add(locationLocal); // dodajanje na plosco
		JLabel lblOznaka2 = new JLabel("Edit text"); // definicija oznake
		lblOznaka2.setHorizontalAlignment(SwingConstants.CENTER); // postavitev na sredino stolpca
		contentPane.add(lblOznaka2); // dodajanje na plosco		
		text = new JTextField(); // prazno besedilno polje
		text.setColumns(120); // stevilo stolpcev
		text.setToolTipText("Enter text that you want to encrypt");
		contentPane.add(text); // dodajanje na plosco
//		JLabel lblOznaka212 = new JLabel("Add attachments"); // definicija oznake
//		lblOznaka212.setHorizontalAlignment(SwingConstants.CENTER); // postavitev na sredino stolpca
//		contentPane.add(lblOznaka212); // dodajanje na plosco		
//		attachment = new JTextField(); // prazno besedilno polje
//		attachment.setColumns(120); // stevilo stolpcev
//		attachment.setToolTipText("Add attachments");
//		contentPane.add(attachment); // dodajanje na plosco
//		JLabel lblOznaka21 = new JLabel("Check remaining space"); // definicija oznake
//		lblOznaka21.setHorizontalAlignment(SwingConstants.CENTER); // postavitev na sredino stolpca
//		contentPane.add(lblOznaka21); // dodajanje na plosco		
//		sizePict = new JTextField(); // prazno besedilno polje
//		sizePict.setColumns(120); // stevilo stolpcev
//		sizePict.setToolTipText("Enter value if you want to check remaing storage, also dont forget to enter which picture you want to check in LOCAL photo");
//		contentPane.add(sizePict); // dodajanje na plosco
		JPanel buttons = new JPanel();
		btnSave = new JButton("Proceed");
		btnSave.addActionListener(new ActionListener() {
			
			//@SuppressWarnings({ "static-access", "null" })
			@Override
			public void actionPerformed(ActionEvent e) {
				SteganographicImage stegon = null;
				SteganographicImage stegon2 = null;
				if(locationWebPhoto.getText().isEmpty()) {
					try {
						stegon =
							     SteganographicImage.loadFromFile(locationLocal.getText());

						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						stegon.setMessage(text.getText());
					} catch (SteganographicImage.SteganographicImageException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//					try {
//						try {
//							stegon.addAttachment(attachment.getText());
//						} catch (SteganographicImage.SteganographicImageException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					} catch (IOException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
					try {
						Random rand = new Random();
						int  n = rand.nextInt(500) + 1;
						stegon.saveToFile("example_encoded2"+n+".png");
						System.out.println("Image saved here: C:\\Users\\JURE\\workspace\\UV_2\\example_encoded2"+n+".png");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
				else if (locationLocal.getText().isEmpty()) {
					try {
						stegon =
							     SteganographicImage.loadFromUrl(locationWebPhoto.getText());						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						stegon.setMessage(text.getText());
					} catch (SteganographicImage.SteganographicImageException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//					try {
//						try {
//							stegon.addAttachment(attachment.getText());
//						} catch (SteganographicImage.SteganographicImageException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					} catch (IOException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
					try {
						Random rand = new Random();
						int  n = rand.nextInt(500) + 1;
						stegon.saveToFile("example_encodedWeb"+n+".png");
						System.out.println("Image saved here: C:\\Users\\JURE\\workspace\\UV_2\\example_encodedWeb"+n+".png");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(!locationWebPhoto2.getText().isEmpty()) {
						
						try {
							stegon2 = SteganographicImage.loadFromUrl(locationWebPhoto2.getText());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							stegon.setMessage(text.getText());
						} catch (SteganographicImage.SteganographicImageException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
//						try {
//							try {
//								stegon.addAttachment(attachment.getText());
//							} catch (SteganographicImage.SteganographicImageException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//						} catch (IOException e2) {
//							// TODO Auto-generated catch block
//							e2.printStackTrace();
//						}
						try {
							Random rand = new Random();
							int  n = rand.nextInt(500) + 1;
							stegon2.saveToFile("Example_ecnodedWebVersion2x"+n+".png");
							System.out.println("Image saved here: C:\\Users\\JURE\\workspace\\UV_2\\example_encodedWebVersion2x"+n+".png");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					dispose();
				}	
//				if(!(sizePict.getText().isEmpty()) && locationWebPhoto.getText().isEmpty() &&locationWebPhoto2.getText().isEmpty()) {
//					try {
//						stegon =
//							     SteganographicImage.loadFromFile(locationLocal.getText());	
//						System.out.printf("remaing % in picture: "+ stegon.getUsedStorage());
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					dispose();
//				}
//				else if(!(sizePict.getText().isEmpty()) && locationLocal.getText().isEmpty()) {
//					try {
//						stegon =
//							     SteganographicImage.loadFromUrl(locationWebPhoto.getText());	
//						System.out.println(stegon.getUsedStorage());
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					dispose();
//				}
			}
		});
		buttons.add(btnSave);
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		buttons.add(btnCancel);
		btnActions = new JButton("Check hidden message");
		btnActions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SteganographicImage stegon = null;
				// TODO Auto-generated method stub
				try {
					stegon = SteganographicImage.loadFromFile(locationLocal.getText());
	    			System.out.printf("Hidden message is: "+stegon.getMessage() +".\n");
//	    			String[] attachments = stegon.listAttachments();
//	    			System.out.println("Attachments:");
//	    			for (int i = 0; i < attachments.length; i++) {
//	    				System.out.println(attachments[i]);
//	    			    try {
//	    			    	try {
//								stegon.saveAttachment(attachments[i]);
//							} catch (SteganographicImage.SteganographicImageException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//	    			  }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		buttons.add(btnActions);
		btnStorage = new JButton("Check remaing storage");
		btnStorage.addActionListener(new ActionListener() {
			SteganographicImage stegon = null;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					stegon = SteganographicImage.loadFromFile(locationLocal.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 System.out.println("Remaining storage is: "+stegon.getUsedStorage()+"%.");
				
			}
		});
		buttons.add(btnStorage);
		contentPane.add(buttons);
		setContentPane(contentPane);
	}

}
