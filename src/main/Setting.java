package main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JSlider;

public class Setting extends Panel {
    private JButton backButton;
    private JButton githubButton;
    private JSlider volumeSlider;
    private Music backgroundMusic;
    private Image backgroundImage;

    public Setting(Frame frame, Music backgroundMusic) {
        super();
        this.backgroundMusic = backgroundMusic;
        this.backgroundImage = new ImageIcon("res\\SettingPanel\\SettingBackground.png").getImage(); 
        setLayout(null);

        initBackButton(frame);
        initVolumeSlider();
        initGitHubButton();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }


    private void initBackButton(Frame frame) {
        ImageIcon backIcon = new ImageIcon("res\\SettingPanel\\JButton_Back.png");
        backButton= new JButton(backIcon);
        backButton.setBounds(548, 510, 185,78);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setOpaque(true);
        this.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchToGameInterface();
            }
        });
    }
    private void initGitHubButton() {
    ImageIcon GitHubIcon = new ImageIcon("res\\SettingPanel\\JButton _Github.png");
    githubButton = new JButton(GitHubIcon);
    githubButton.setBounds(555, 420, 171, 81);
    githubButton.setFocusPainted(false);
    githubButton.setBorder(BorderFactory.createEmptyBorder());
    githubButton.setOpaque(true);
    this.add(githubButton);

    githubButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            openGitHubLink();
        }
    });
}

    private void openGitHubLink() {
    try {
        URI uri = new URI("https://github.com/Chopper226/PKGame");
        Desktop.getDesktop().browse(uri);
    } catch (URISyntaxException | IOException ex) {
        ex.printStackTrace();
    }
}


    private void initVolumeSlider() {
        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50); // 初始音量?50%
        volumeSlider.setBounds(350, 300, 580, 60);
        volumeSlider.setMajorTickSpacing(10);
        volumeSlider.setMinorTickSpacing(1);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumeSlider.setFont(new Font("Arial", Font.PLAIN, 15)); // ?置字形
        volumeSlider.setForeground(Color.BLACK); 
        volumeSlider.setBackground(new Color(225, 213, 253));
        this.add(volumeSlider);
    
        volumeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int volume = volumeSlider.getValue();
                setMusicVolume(volume);
            }
        });
    }
    
    private void setMusicVolume(int volume) {
        if (backgroundMusic != null) {
            float volumeLevel = volume / 100.0f; 
            backgroundMusic.setVolume(volumeLevel);
        }
    }
}
