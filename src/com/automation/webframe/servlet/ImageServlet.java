/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.servlet <br>
 * 文件名：ImageServlet.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:05:57<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.automation.webframe.utils.SessionUtils;

/**
 * 
 * 类名称：ImageServlet <br>
 * 类描述：图片Servlet <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:05:57 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ImageServlet extends HttpServlet {

	/**  */
	private static final long serialVersionUID = 1L;

	/** 验证码图片的宽度 */
	private int width = 60;

	/** 验证码图片的高度 */
	private int height = 20;

	/** 验证码字符个数 */
	private int codeCount = 4;

	/**  */
	private int x = 0;

	/** 字体高度 */
	private int fontHeight;

	private int codeY;

	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 方法：doGet <br>
	 * 描述：TODO <br>
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	/**
	 * 方法：doPost <br>
	 * 描述：TODO <br>
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * 方法：init <br>
	 * 描述：初始化 <br>
	 * 
	 * @throws ServletException
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() throws ServletException {
		// 从web.xml中获取初始信息
		// 宽度
		String strWidth = this.getInitParameter("width");
		// 高度
		String strHeight = this.getInitParameter("height");
		// 字符个数
		String strCodeCount = this.getInitParameter("codeCount");
		// System.out.println("strWidth==" + strWidth + ", strHeight==" +
		// strHeight
		// + ", strCodeCount==" + strCodeCount);
		// 将配置的信息转换成数值
		try {
			if (strWidth != null && strWidth.length() != 0) {
				width = Integer.parseInt(strWidth);
			}
			if (strHeight != null && strHeight.length() != 0) {
				height = Integer.parseInt(strHeight);
			}
			if (strCodeCount != null && strCodeCount.length() != 0) {
				codeCount = Integer.parseInt(strCodeCount);
			}
		} catch (NumberFormatException e) {
		}
		x = width / (codeCount + 1);
		fontHeight = height;
		codeY = height;
	}

	/**
	 * 方法：service <br>
	 * 描述：服务 <br>
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws java.io.IOException
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// 创建一个随机数生成器类
		Random random = new Random();
		// 将图像填充为白色
		g.setColor(getRandColor(220, 250));
		g.fillRect(0, 0, width, height);
		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("黑体", Font.BOLD, fontHeight - 5);
		// 设置字体。
		g.setFont(font);
		// 画边框。
		// g.setColor(Color.pink);
		// g.drawRect(0, 0, width - 1, height - 1);
		// 随机产生150条干扰线，使图象中的认证码不易被其它程序探测到。
		/*
		 * g.setColor(getRandColor(120, 200)); for (int i = 0; i < 150; i++) {
		 * int x = random.nextInt(width); int y = random.nextInt(height); int xl
		 * = random.nextInt(10); int yl = random.nextInt(10); g.drawLine(x,
		 * y,x+xl,y+yl); }
		 */
		// 随机产生450个干扰点，使图象中的认证码不易被其它程序探测到。
		g.setColor(getRandColor(120, 200));
		for (int i = 0; i < 550; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			g.drawOval(x, y, 0, 0);
		}

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字。
			String strRand = String.valueOf(codeSequence[random.nextInt(62)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			g.setColor(getRandColor(20, 130));
			// 用随机产生的颜色将验证码绘制到图像中。
			g.drawString(strRand, (i + 1) * x - 7, codeY - 5);
			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
		// 将四位数字的验证码保存到Session中。
		// HttpSession session = req.getSession();
		// session.setAttribute("validateCode", randomCode.toString());
		SessionUtils.setValidateCode(req, randomCode.toString().toLowerCase());
		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}

	/**
	 * 方法：getRandColor <br>
	 * 描述：产生随机颜色 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:08:35 <br>
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static Color getRandColor(int num1, int num2) {
		Random random = new Random();
		if (num1 > 255)
			num1 = 255;
		if (num2 > 255)
			num2 = 255;
		int r = num1 + random.nextInt(num2 - num1);
		int g = num1 + random.nextInt(num2 - num1);
		int b = num1 + random.nextInt(num2 - num1);
		return new Color(r, g, b);
	}

}
