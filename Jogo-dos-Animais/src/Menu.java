import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

	static JFrame jfmenu;
	static JPanel jptela;
	static JLabel texto;
	static JButton jbOk;
	static Arvore arvore = new Arvore();

	public static void main(String[] args) {

		menu();

	}

	static void menu() {

		jfmenu = new JFrame("Animais");
		jfmenu.setSize(250, 150);
		jfmenu.setLocationRelativeTo(jfmenu);
		jfmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfmenu.setResizable(false);
		jfmenu.setVisible(true);

		jptela = new JPanel();
		jptela.setSize(250, 150);
		jptela.setLayout(null);
		jfmenu.add(jptela);
		jptela.setVisible(true);

		texto = new JLabel("Pense em um animal");
		texto.setSize(200, 50);
		texto.setLocation(60, 10);
		jptela.add(texto);
		texto.setVisible(true);

		jbOk = new JButton("Ok");
		jbOk.setSize(50, 20);
		jbOk.setLocation(100, 60);
		jptela.add(jbOk);
		jbOk.setVisible(true);

		IniciarArvore();
		Botao();

	}

	static void IniciarArvore() {

		No no = new No();

		arvore.raiz = no; // � desse cara que voc� vai come�ar
		no.valor = "O animal que voc� pensou vive na �gua?";

	}

	static void PercorrerArvore(No raiz, String animal) {

		if (JOptionPane.showConfirmDialog(null, raiz.valor, "Jogo dos animais", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

			animal = raiz.resposta;
			if (raiz.esquerda != null) {
				PercorrerArvore(raiz.esquerda, animal);

			} else {
				if (JOptionPane.showConfirmDialog(null, "O animal que voc� pensou � o " + animal + "?",
						"Jogo dos animais", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					JOptionPane.showMessageDialog(null, "Acertei novamente!");
				} else {

					No no = new No();
					no.resposta = JOptionPane.showInputDialog("Qual � o animal que voc� pensou?");
					no.valor = "O animal que voc� pensou "
							+ JOptionPane.showInputDialog("Um(a) " + no.resposta + " _____ mas um " + animal + " n�o.")
							+ "?";

					raiz.esquerda = no;

				}
			}

		} else {

			if (raiz.direita != null) {
				PercorrerArvore(raiz.direita, animal);

			} else {
				if (JOptionPane.showConfirmDialog(null, "O animal que voc� pensou � o " + animal + "?",
						"Jogo dos animais", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					JOptionPane.showMessageDialog(null, "Acertei novamente!");
				} else {

					No no = new No();
					no.resposta = JOptionPane.showInputDialog("Qual � o animal que voc� pensou?");
					no.valor = "O animal que voc� pensou "
							+ JOptionPane.showInputDialog("Um(a) " + no.resposta + " _____ mas um " + animal + " n�o.")
							+ "?";

					raiz.direita = no;

				}
			}

		}

	}

	static void Botao() {
		jbOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null, arvore.raiz.valor, "Jogo dos animais",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					if (arvore.raiz.esquerda != null) {
						PercorrerArvore(arvore.raiz.esquerda, "Tubar�o");
					} else {
						if (JOptionPane.showConfirmDialog(null, "O animal que voc� pensou � o Tubar�o?",
								"Jogo dos animais", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

							JOptionPane.showMessageDialog(null, "Acertei novamente!");
						} else {

							No no = new No();
							no.resposta = JOptionPane.showInputDialog("Qual � o animal que voc� pensou?");
							no.valor = "O animal que voc� pensou "
									+ JOptionPane.showInputDialog("Um(a) " + no.resposta + " _____ mas um tubar�o n�o.")
									+ "?";

							arvore.raiz.esquerda = no;

						}
					}

				} else {
					if (arvore.raiz.direita != null) {
						PercorrerArvore(arvore.raiz.direita, "Macaco");
					} else {
						if (JOptionPane.showConfirmDialog(null, "O animal que voc� pensou � o macaco?",
								"Jogo dos animais", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

							JOptionPane.showMessageDialog(null, "Acertei novamente!");
						} else {

							No no = new No();
							no.resposta = JOptionPane.showInputDialog("Qual � o animal que voc� pensou?");
							no.valor = "O animal que voc� pensou "
									+ JOptionPane.showInputDialog("Um(a) " + no.resposta + " _____ mas um macaco n�o.")
									+ "?";

							arvore.raiz.direita = no;

						}
					}

				}

			}
		});

	}
}
