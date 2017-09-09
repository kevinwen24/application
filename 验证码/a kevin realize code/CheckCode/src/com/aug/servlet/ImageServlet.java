package com.aug.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ImageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Color color = new Color(200,150,255);
		g.setColor(color);
		g.fillRect(0, 0, 68, 22);
		
		char[] c = "abcdefghigklmnopqistuvwxyz0123456789".toCharArray();
		Random random = new Random();
		int len = c.length,index;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			index = random.nextInt(len);
			g.setColor(new Color(random.nextInt(88), random.nextInt(188),
					random.nextInt(255)));
			g.drawString(c[index]+"", i*15 + 3, 18);
			sb.append(c[index]);
		}
		HttpSession session = request.getSession();
		session.setAttribute("checkCode", sb.toString());
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
