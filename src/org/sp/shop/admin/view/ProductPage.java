package org.sp.shop.admin.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.sp.shop.admin.view.product.ExcelPage;
import org.sp.shop.admin.view.product.ListPage;
import org.sp.shop.admin.view.product.ProductSubPage;
import org.sp.shop.admin.view.product.RegistPage;

public class ProductPage extends Page{
	JPanel p_west; 
	JPanel p_center;
	String[] subTitle= {"상품목록","상품등록","엑셀업로드"};
	JLabel[] subNavi;
	
	//상품등록, 상품목록, 엑셀로관리..등등의 페이지들을 보유 
	ProductSubPage[] pages;
	
	public ProductPage() {
		p_west = new JPanel();
		p_center = new JPanel();
		createNavi();
		pages = new ProductSubPage[3];
		pages[0] = new RegistPage();
		pages[1] = new ListPage();
		pages[2] = new ExcelPage();
		
		//스타일
		p_west.setPreferredSize(new Dimension(150, 600));
		p_west.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1),"상품관리"));
		p_center.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1),"상품정보"));
		
		setLayout(new BorderLayout());
		
		//조립
		for(int i=0; i<pages.length;i++) {
			p_center.add(pages[i]);			
		}	
		
		updateUI();
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		//디폴트로 보여질 페이지 
		showHide(0);
	}
	
	public void createNavi() {
		subNavi = new JLabel[subTitle.length];//배열생성 
		
		for(int i=0;i<subTitle.length;i++) {
			subNavi[i] = new JLabel(subTitle[i]);
			subNavi[i].setPreferredSize(new Dimension(140, 45));
			p_west.add(subNavi[i]);
		}
	}
	
	//페이지 전환처리 
	public void showHide(int n) { //보이게하고 싶은 index 남 넘겨받는다
		System.out.println(n); 
		
		for(int i=0;i<pages.length;i++) {
			if(i==n) { //넘겨받은 매개변수와 i가 일치할때만 보이게..
				pages[i].setVisible(true); //보이게 처리
			}else {
				pages[i].setVisible(false);//안보이게 처리
			}
		}		
	}
	
}





