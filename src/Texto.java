import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;
//import javax.swing.JTextField;

public class Texto implements ActionListener
{
    // Declara Componentes
    JLabel rotulo;
    JTextArea area;
    //JTextField texto;
    JButton botao;
    JButton botao2;


    // Cria painel
    public Container CriaPainel()
    {
        // Cria conteudo da area de texto
        String conteudo =  "Digite sua tarefa:";

        // Cria componentes
        rotulo = new JLabel("Castro de Tarefas:");
        area = new JTextArea(conteudo);
        rotulo.setVerticalTextPosition(CENTER);

        //colocar SelectBox aqui:
        JLabel Priority = new JLabel("Prioridade");
        String[] nivelPriority = {"Alto", "Normal", "Baixo"};
        JComboBox ComboBoxPrioridade = new JComboBox(nivelPriority);

        //colocar o checkbox aqui:

        JCheckBox lembrarCheckBox = new JCheckBox("Finalizado                 ");
        lembrarCheckBox.setSelected(true);

        //texto = new JTextField();
        botao = new JButton("GRAVAR");
        botao2 = new JButton("CANCELAR");

        // Cria evento do botão
        botao.addActionListener(this);
        botao2.addActionListener(this);

        botao.setVerticalTextPosition(AbstractButton.BOTTOM);
        botao.setHorizontalTextPosition(AbstractButton.LEADING);
        botao2.setVerticalTextPosition(AbstractButton.BOTTOM);
        botao2.setHorizontalTextPosition(CENTER);

        // Adiciona valores as propriedades da area de texto
        area.setFont(new Font("Serif", Font.ITALIC, 12));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        // Cria barra de rolagem e adiciona a area de texto
        JScrollPane scrooll = new JScrollPane(area);

        // Adiciona valores as propriedades da barra de rolagem

        // Barra vertical
        scrooll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Tamanho da barra
        scrooll.setPreferredSize(new Dimension(250, 250));



        // Borda com titulo
        scrooll.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Tarefa"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                        scrooll.getBorder()));




        // Cria o painel
        JPanel painel = new  JPanel();


        // Cria um layout para os componentes
        painel.setLayout(new BoxLayout(painel,BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        // Alinha componentes
        rotulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        //area.setAlignmentX(Component.CENTER_ALIGNMENT);
        //botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        //botao2.setAlignmentX(Component.CENTER_ALIGNMENT);




        // Adiciona componentes no painel
        painel.add(rotulo);
        painel.add(Box.createVerticalStrut(10));

        // Adiciona a barra de rolagem pois a area de texto
        // está já foi adiciona dentro dela logo acima.
        painel.add(scrooll);
        painel.add(Box.createVerticalStrut(5));
        //painel.add(texto);

        painel.add(Box.createVerticalStrut(5));

        // add ComboBox
        painel.add(ComboBoxPrioridade);
        painel.add(Box.createVerticalStrut(5));

        //check box
        painel.add(lembrarCheckBox);
        painel.add(Box.createVerticalStrut(5));

        //add botão
        painel.add(botao);
        painel.add(Box.createVerticalStrut(5));
        painel.add(botao2);
        painel.add(Box.createVerticalStrut(5));




        // Retorna o painel
        return painel;
    }

    public void actionPerformed(ActionEvent arg0)
    {
        // Cria evento para o botão
        if (arg0.getSource() == botao)
        {
            //area.append(texto.getText() + "\n");
        }
    }

    // Cria a Title do app
    public static void criaGUI()
    {
        // Cria formulario
        JFrame formulario = new JFrame("CADASTRO DE TAREFAS");

        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria nova instancia da classe
        Texto texto = new Texto();

        // adiciona painel ao formulario
        formulario.setContentPane(texto.CriaPainel());

        // Compacta componetes no formulario
        formulario.pack();

        // Mostra formulario
        formulario.setVisible(true);
    }


}