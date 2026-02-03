import java.awt.*;
import java.awt.event.*;
import java.io.*;

public
    class MyFrame
    extends Frame {

    public static void main(String[] args) {
        new MyFrame();
    }

    private int[] circles;
    private int circlesCount;

    public MyFrame() {
        this.circles = new int[1000];
        this.circlesCount = 0;

        Panel drawPanel = new Panel(){
            public void paint(Graphics g){
                for(int i = 0; i < circles.length; i++){
                    int[] decoded = PositionAndColor.decode(
                        MyFrame.this.circles[i]
                    );
                    g.setColor(PositionAndColor.byteToColor(decoded[2]));
                    g.fillOval(decoded[0]-5, decoded[1]-5, 10, 10);
                }
            }
        };

        drawPanel.addMouseListener(
            new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    MyFrame.this.circles[circlesCount++] = PositionAndColor.encode(
                        e.getX(),
                        e.getY(),
                        new Color(
                            (int)(Math.random()*255),
                            (int)(Math.random()*255),
                            (int)(Math.random()*255)
                        )
                    );
                    drawPanel.repaint();
                }
            }
        );

        Panel actionPanel = new Panel();

        Button loadButton = new Button("Load");
        Button saveButton = new Button("Save");

        actionPanel.setLayout(
            new FlowLayout()
        );

        actionPanel.add(loadButton);
        actionPanel.add(saveButton);

        this.setLayout(new BorderLayout());
        this.add(actionPanel, BorderLayout.SOUTH);
        this.add(drawPanel, BorderLayout.CENTER);

        this.setSize(500, 500);
        this.setVisible(true);

        this.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        loadButton.addActionListener(
            new ActionListener() {
//TODO  loadButton actionPerformed implementation
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            }
        );

        saveButton.addActionListener(
            new ActionListener() {
//TODO  saveButton actionPerformed implementation
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            }
        );
    }
//TODO saveInt method

//TODO loadInt method

}
