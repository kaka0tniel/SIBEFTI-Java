package Controller;

import Driver.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.PollingBemModel;
import View.*;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author HansTCS
 */
public class PollingBemController implements ActionListener {

    PollingBemFtie viewPolling = new PollingBemFtie();
    BemFTIE bem = new BemFTIE();
    PollingBemModel modelPolling = new PollingBemModel();

    public PollingBemController(PollingBemFtie viewPolling, PollingBemModel modelPolling) {
        this.modelPolling = modelPolling;
        this.viewPolling = viewPolling;
        viewPolling.btnOpt1.setBorderPainted(false);
        viewPolling.btnOpt2.setBorderPainted(false);
        viewPolling.btnOpt3.setBorderPainted(false);
        viewPolling.btnOpt1.addActionListener(this);
        viewPolling.btnOpt2.addActionListener(this);
        viewPolling.btnOpt3.addActionListener(this);
        viewPolling.btnBack.addActionListener(this);
    }

    public void back() {
        this.viewPolling.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewPolling.btnOpt1) {
            int polling_id = 1;

            int update = modelPolling.updatePolling(polling_id);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Terimakasih atas polling anda");
                viewPolling.btnOpt1.setEnabled(false);
                viewPolling.btnOpt2.setEnabled(false);
                viewPolling.btnOpt3.setEnabled(false);
                bem.btnPoll.setEnabled(false);
                BerandaBemUserDriver beranda = new BerandaBemUserDriver();
                this.back();
                beranda.start();
            } else {
                JOptionPane.showMessageDialog(null, "Polling gagal");
            }
        }
        if (e.getSource() == viewPolling.btnOpt2) {
            int polling_id = 2;

            int update = modelPolling.updatePolling(polling_id);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Terimakasih atas polling anda");
                viewPolling.btnOpt1.setEnabled(false);
                viewPolling.btnOpt2.setEnabled(false);
                viewPolling.btnOpt3.setEnabled(false);
                BerandaBemUserDriver beranda = new BerandaBemUserDriver();
                this.back();
                beranda.start();
                bem.btnPoll.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Polling gagal");
            }
        }
        if (e.getSource() == viewPolling.btnOpt3) {
            int polling_id = 3;

            int update = modelPolling.updatePolling(polling_id);

            if (update > 0) {
                JOptionPane.showMessageDialog(null, "Terimakasih atas polling anda");
                viewPolling.btnOpt1.setEnabled(false);
                viewPolling.btnOpt2.setEnabled(false);
                viewPolling.btnOpt3.setEnabled(false);
                BerandaBemUserDriver beranda = new BerandaBemUserDriver();
                this.back();
                beranda.start();
                bem.btnPoll.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Polling gagal");
            }
        }
        if (e.getSource() == viewPolling.btnBack) {
            bem.btnPoll.setEnabled(false);
            this.back();
            BerandaBemUserDriver beranda = new BerandaBemUserDriver();
            beranda.start();
        }
    }

}
