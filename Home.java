import java.awt.*;
import java.awt.print.*;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.util.*;
import javax.swing.*;

public class Home {

	Double totalAmount = 0.0;
	Double cash = 0.0;
	Double balance = 0.0;
	Double bHeight = 0.0;

	/*
	 * ArrayList<String> itemName = new ArrayList<>(); ArrayList<String> quantity =
	 * new ArrayList<>(); ArrayList<String> itemPrice = new ArrayList<>();
	 * ArrayList<String> subtotal = new ArrayList<>();
	 * 
	 * 
	 * private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	 * 
	 * itemName.add(txtitemname.getText()); quantity.add(txtquantity.getText());
	 * itemPrice.add(txtprice.getText()); subtotal.add(txtsubtotal.getText());
	 * totalAmount = totalAmount+ Double.valueOf(txtsubtotal.getText());
	 * txttotalAmount.setText(totalAmount+""); clear();
	 * 
	 * }
	 */
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		//bHeight = Double.valueOf(itemName.size());

		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(new BillPrintable(), getPageFormat(pj));
		try {
			pj.print();

		} catch (PrinterException ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * private void clear() {
	 * 
	 * txtitemname.setText(""); txtquantity.setText(""); txtprice.setText("");
	 * txtsubtotal.setText("");
	 * 
	 * }
	 */

	public PageFormat getPageFormat(PrinterJob pj) {

		PageFormat pf = pj.defaultPage();
		Paper paper = pf.getPaper();

		double bodyHeight = bHeight;
		double headerHeight = 5.0;
		double footerHeight = 5.0;
		double width = cm_to_pp(8);
		double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
		paper.setSize(width, height);
		paper.setImageableArea(0, 10, width, height - cm_to_pp(1));

		pf.setOrientation(PageFormat.PORTRAIT);
		pf.setPaper(paper);

		return pf;
	}

	protected static double cm_to_pp(double cm) {
		return toPPI(cm * 0.393600787);
	}

	protected static double toPPI(double inch) {
		return inch * 72d;
	}

	public class BillPrintable implements Printable {

		public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

			//int r = itemName.size();
			ImageIcon icon = new ImageIcon("power_icon.png");
			int result = NO_SUCH_PAGE;
			if (pageIndex == 0) {

				Graphics2D g2d = (Graphics2D) graphics;
				double width = pageFormat.getImageableWidth();
				g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

				try {
					int y = 20;
					int yShift = 10;
					int headerRectHeight = 15;

					g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
					//g2d.drawImage(icon.getImage(), 50, 20, 90, 30, rootPane);
					y += yShift + 30;
					g2d.drawString("-------------------------------------------", 12, y);
					y += yShift;
					g2d.drawString("           Project On           ", 12, y);
					y += yShift;
					g2d.drawString("     Electricity Billing System ", 12, y);
					y += yShift;
					g2d.drawString("     Made By Biaksh Mahapatra   ", 12, y);
					y += yShift;
					g2d.drawString("             Contact Us         ", 12, y);
					y += yShift;
					g2d.drawString("          +91 9348795026        ", 12, y);
					y += yShift;
					g2d.drawString("-------------------------------------------", 12, y);
					y += headerRectHeight;

					g2d.drawString(" Custmer Name                  Bill   ", 10, y);
					y += yShift;
					g2d.drawString("-------------------------------------------", 10, y);
					y += headerRectHeight;
					/*
					 * for(int s=0; s<r; s++) {
					 * g2d.drawString(" "+itemName.get(s)+"                            ",10,y);y+=
					 * yShift; g2d.drawString("      "+quantity.get(s)+" * "+itemPrice.get(s),10,y);
					 * g2d.drawString(subtotal.get(s),160,y);y+=yShift;
					 * 
					 * }
					 * 
					 * 
					 * 
					 * g2d.drawString("-------------------------------------------",10,y);y+=yShift;
					 * g2d.drawString(" Total amount:               "+txttotalAmount.getText()+"   "
					 * ,10,y);y+=yShift;
					 * g2d.drawString("-------------------------------------------",10,y);y+=yShift;
					 * g2d.drawString(" Cash      :                 "+txtcash.getText()+"   ",10,y);
					 * y+=yShift;
					 * g2d.drawString("-------------------------------------------",10,y);y+=yShift;
					 * g2d.drawString(" Balance   :                 "+txtbalance.getText()+"   ",10,
					 * y);y+=yShift;
					 */

					g2d.drawString("*******************************************", 10, y);
					y += yShift;
					g2d.drawString("     THANK YOU FOR USING THIS SOFTWARE     ", 10, y);
					y += yShift;
					g2d.drawString("*******************************************", 10, y);
					y += yShift;
					g2d.drawString("       SOFTWARE BY:Bikash Mahapatra        ", 10, y);
					y += yShift;
					g2d.drawString("   	   CONTACT: contact@codeguid.com       ", 10, y);
					y += yShift;

				} catch (Exception e) {
					e.printStackTrace();
				}

				result = PAGE_EXISTS;
			}
			return result;
		}
	}
}
