import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JogoCobra extends JFrame {

    private LinkedList<Point> cobra = new LinkedList<>();
    private Point maca;
    private int direcaoAtual = KeyEvent.VK_RIGHT;

    private final int TAM = 20;
    private final int LARGURA = 20;
    private final int ALTURA = 20;

    private int pontuacao = 0;

    private JPanel canvas;

    public JogoCobra() {

        setTitle("Jogo da Cobrinha");
        setSize(LARGURA * TAM, ALTURA * TAM);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa cobra
        cobra.add(new Point(5, 5));
        cobra.add(new Point(4, 5));
        cobra.add(new Point(3, 5));

        gerarNovaMaca();

        // Canvas
        canvas = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Fundo
                g.setColor(new Color(30, 30, 30));
                g.fillRect(0, 0, getWidth(), getHeight());

                // Grade
                g.setColor(new Color(50, 50, 50));
                for (int i = 0; i < LARGURA; i++) {
                    g.drawLine(i * TAM, 0, i * TAM, ALTURA * TAM);
                }
                for (int i = 0; i < ALTURA; i++) {
                    g.drawLine(0, i * TAM, LARGURA * TAM, i * TAM);
                }

                // Cobra
                g.setColor(new Color(0, 200, 0));
                for (Point p : cobra) {
                    g.fillRoundRect(p.x * TAM, p.y * TAM, TAM, TAM, 10, 10);
                }

                // Maçã
                g.setColor(Color.RED);
                g.fillOval(maca.x * TAM, maca.y * TAM, TAM, TAM);
                g.setColor(Color.WHITE);
                g.drawOval(maca.x * TAM, maca.y * TAM, TAM, TAM);
            }
        };

        add(canvas);

        // Teclado
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                direcaoAtual = e.getKeyCode();
            }
        });

        setFocusable(true);

        // GAME LOOP
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new GameLoop(), 0, 150);

        setVisible(true);
    }

    // Game Loop
    class GameLoop extends TimerTask {
        @Override
        public void run() {

            Point cabeca = cobra.getFirst();
            Point novaCabeca = new Point(cabeca);

            // Movimento
            if (direcaoAtual == KeyEvent.VK_UP) novaCabeca.y--;
            if (direcaoAtual == KeyEvent.VK_DOWN) novaCabeca.y++;
            if (direcaoAtual == KeyEvent.VK_LEFT) novaCabeca.x--;
            if (direcaoAtual == KeyEvent.VK_RIGHT) novaCabeca.x++;

            // Atravessar parede (Pac-Man)
            if (novaCabeca.x < 0) novaCabeca.x = LARGURA - 1;
            if (novaCabeca.x >= LARGURA) novaCabeca.x = 0;
            if (novaCabeca.y < 0) novaCabeca.y = ALTURA - 1;
            if (novaCabeca.y >= ALTURA) novaCabeca.y = 0;

            // Comer maçã
            if (novaCabeca.equals(maca)) {
                pontuacao++;
                gerarNovaMaca();
            } else {
                cobra.removeLast();
            }

            cobra.addFirst(novaCabeca);

            setTitle("Jogo da Cobrinha | Pontos: " + pontuacao);

            canvas.repaint();
        }
    }

    // Gerar maçã (sem nascer na cobra)
    private void gerarNovaMaca() {
        Random rand = new Random();
        Point nova;

        do {
            nova = new Point(rand.nextInt(LARGURA), rand.nextInt(ALTURA));
        } while (cobra.contains(nova));

        maca = nova;
    }
}