import java.awt.*;
import java.awt.event.*;
class Frm11 extends Frame implements ActionListener
{
	int v1,v2,res,flg;
	char opr,ch;
	String p,q;
	TextField t1;
	Panel r;
	Button[]btn;
	Frm11()
	{
	   super("Calci");
	   p=new String();
	   q=new String();
       t1=new TextField(10);
 	   t1.setEditable(false);
	   add(t1,BorderLayout.NORTH);
	   String [] cap=new String[]{"1","2","3","+","4","5","6","-","7","8","9","*","0","C","=","/"};
	   r=new Panel();
	   r.setLayout(new GridLayout(4,4,5,5));
	   btn=new Button[16];
	   for(int i=0;i<16;i++)
	   {
		   btn[i]=new Button(cap[i]);
		   btn[i].addActionListener(this);
		   r.add(btn[i]);
	   }
	   add(r,BorderLayout.CENTER);
	   flg=0;						
	   addWindowListener(new WindowAdapter()
	   {
		   public void windowClosing(WindowEvent e)
		   {
			   System.exit(0);
		   }
	   });
	   setSize(400,300);
	   setVisible(true);
	}
	void comp()
	{
		switch(opr)
		{
			case '+':
			    res=v1+v2;
				break;
			case '-':
			    res=v1-v2;
				break;
			case '*':
			    res=v1*v2;
				break;
			case '/':
			    res=v1/v2;
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		ch=(e.getActionCommand()).charAt(0);
		if(ch=='C')
        {
			flg=0;
			p="";
			q="";
			t1.setText("");
			return;
		}			
		if(ch=='=')
	    {
			if(flg==1)
			{
				try
				{
					v2=Integer.parseInt(t1.getText());
				}
				catch(Exception e1)
				{}
				comp();
				t1.setText(""+res);
				p="";q="";flg=0;
			}
			return;
		}
		if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
		{
			if(flg==0)
			{
				try
				{
					v1=Integer.parseInt(t1.getText());;
				}
				catch(Exception e1){}
				opr=ch;
				flg=1;
			}
			else
			{
				try
				{
					v2=Integer.parseInt(t1.getText());
				}
				catch(Exception e1){}
				comp();
				v1=res;
				t1.setText(""+v1);
				opr=ch;
			}
			p="";q="";
			return;
		}
		p=p+ch;
		t1.setText(p);
	}
	public static void main(String[]args)
	{
		Frm11 a=new Frm11();
	}
}