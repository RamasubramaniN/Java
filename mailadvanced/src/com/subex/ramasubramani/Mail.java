package com.subex.ramasubramani;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

public class Mail
{

	private final String _CONTENT_HTML = "text/html";
	private final String _CONTENT_HOST = "smtp.gmail.com";
	private final String _PORT = "25";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	static ArrayList<String> attachments = new ArrayList<String>();
	private static Properties properties = new Properties();

	public static void main( String[] args ) throws MessagingException
	{
		Mail sender = new Mail();

		try
		{
			properties.load( new FileInputStream( "config.properties" ) );
		}
		catch ( FileNotFoundException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch ( IOException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// sending mail, without attachment.
		sender.send( properties.getProperty( "mailId" ), "veerachenan@gmail.com", "Hi, this is generated through java code", "this is a h1 tag so, it may appears in huge size! :D" );

		// sending another mail, with 2 attachments.

		attachments.add( "D://Softwares/maven/Attachment.txt" );

		sender.send( properties.getProperty( "mailId" ), "veerachenan@gmail.com", "Hi Ramasubramani,\n\t This is my java mail with attachments", "this is a h1 tag so, it may appears in huge size! :D", attachments );

	}

	private void send( String from, String to, String subject, String body ) throws MessagingException
	{
		Properties props = new Properties();
		props.put( "mail.smtp.host", _CONTENT_HOST );
		props.put( "mail.smtp.auth", "true" );
		props.put( "mail.debug", "true" );
		props.put( "mail.smtp.starttls.enable", "true" );
		props.put( "mail.smtp.port", _PORT );
		props.put( "mail.smtp.socketFactory.port", _PORT );
		props.put( "mail.smtp.socketFactory.fallback", "false" );

		Session session = Session.getDefaultInstance( props, new javax.mail.Authenticator()
		{

			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication( properties.getProperty( "username" ), properties.getProperty( "password" ) );
			}
		} );
		Message message = new MimeMessage( session );
		message.addRecipient( RecipientType.TO, new InternetAddress( to ) );
		message.addFrom( new InternetAddress[]
		{ new InternetAddress( from ) } );
		message.setSubject( subject );
		message.setContent( body, _CONTENT_HTML );
		Transport.send( message );
	}

	private void send( String from, String to, String subject, String body, ArrayList attachments ) throws MessagingException
	{
		Properties props = new Properties();
		props.put( "mail.smtp.host", _CONTENT_HOST );
		props.put( "mail.smtp.auth", "true" );
		props.put( "mail.debug", "true" );
		props.put( "mail.smtp.port", _PORT );
		props.put( "mail.smtp.starttls.enable", "true" );
		props.put( "mail.smtp.socketFactory.port", _PORT );
		props.put( "mail.smtp.socketFactory.class", SSL_FACTORY );
		props.put( "mail.smtp.socketFactory.fallback", "false" );

		Session session = Session.getDefaultInstance( props, new javax.mail.Authenticator()
		{

			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication( properties.getProperty( "username" ), properties.getProperty( "password" ) );
			}
		} );
		session.setDebug( true );
		Message message = new MimeMessage( session );
		message.addRecipient( RecipientType.TO, new InternetAddress( to ) );
		message.addFrom( new InternetAddress[]
		{ new InternetAddress( from ) } );
		message.setSubject( subject );
		MimeBodyPart mbp1 = new MimeBodyPart();
		mbp1.setText( body );
		mbp1.setContent( body, _CONTENT_HTML );
		Multipart mp = new MimeMultipart();
		mp.addBodyPart( mbp1 );

		for ( String fileName : Mail.attachments )
		{
			MimeBodyPart mbp = new MimeBodyPart();
			FileDataSource fds = new FileDataSource( fileName );
			mbp.setDataHandler( new DataHandler( fds ) );
			mbp.setFileName( fds.getName() );
			mp.addBodyPart( mbp );
		}

		message.setContent( mp );
		message.setSentDate( new Date() );
		Transport.send( message );
	}

	private Session getSession()
	{
		Authenticator authenticator = new Authenticator();
		Properties properties = new Properties();
		properties.setProperty( "mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName() );
		properties.setProperty( "mail.smtp.auth", "true" );
		properties.setProperty( "mail.smtp.host", _CONTENT_HOST );
		properties.put( "mail.smtp.socketFactory.class", SSL_FACTORY );
		properties.setProperty( "mail.smtp.port", _PORT );
		return Session.getInstance( properties, authenticator );
	}

	private class Authenticator extends javax.mail.Authenticator
	{
		private PasswordAuthentication authentication;

		public Authenticator()
		{
			authentication = new PasswordAuthentication( properties.getProperty( "username" ), properties.getProperty( "password" ) );
		}

		protected PasswordAuthentication getPasswordAuthentication()
		{
			return authentication;
		}
	}
}