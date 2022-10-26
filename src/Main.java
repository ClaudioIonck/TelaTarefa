

public class Main {
    public static void main(String[] args) {
        // Cria thread do swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                // Chama a GUI
                Texto.criaGUI();
            }
        });

    }
}