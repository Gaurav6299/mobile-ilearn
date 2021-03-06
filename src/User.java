import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.util.Vector;

public abstract class User implements UserInterface {
	public void displayClasses()
	{
		for (int i = 0; i < classes.size(); i++)
		{
			System.out.println(classes.get(i).toString());
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = new String(name);
	}
	public Rank getRank()
	{
		return this.rank;
	}
	public void setRank(Rank rank)
	{
		this.rank = rank;
	}
	public ArrayList<Class> getClasses()
	{
		return this.classes;
	}
	public void setClasses(ArrayList<Class> classes)
	{
		this.classes = (ArrayList<Class>) classes.clone();
	}
	public String getNetid()
	{
		return this.netid;
	}
	public void setNetid(String netid)
	{
		this.netid = new String(netid);
	}
	public int getSid()
	{
		return this.sid;
	}
	public void setSid(int sid)
	{
		this.sid = sid;
	}
	public ArrayList<ArrayList<Vector>> getSnames()
	{
		return this.snames;
	}
	public void setSnames(ArrayList<ArrayList<Vector>> s)
	{
		this.snames = (ArrayList<ArrayList<Vector>>) s.clone();
	}
	
	public void writeJson(String filename, Rank rank, ArrayList<ArrayList<Vector>> snames)
	{
		try{
			PrintWriter file = new PrintWriter(filename);
			file.println("[");
			for (int i = 0; i < classes.size(); i++)
			{
				if (filename.equals("course.json")) {
                    for (int j = 0; j < snames.get(i).size(); j++) {
                        if (i != (classes.size() - 1) || j != (snames.get(i).size() - 1))
                            file.println(classes.get(i).toString(rank, snames.get(i).get(j)) + ",");
                        else
                            file.println(classes.get(i).toString(rank, snames.get(i).get(j)));
                    }
                }
                else
                {
                    if(i != this.getClasses().size() - 1)
                        file.println(classes.get(i).toString(rank, snames.get(i).get(0)) + ",");
                    else
                        file.println(classes.get(i).toString(rank, snames.get(i).get(0)));
                }

			}
			file.println("]");
	        file.close();
            File f = new File(filename);
	    }
		catch(Exception e) {
	        System.out.println("ERROR");
	        e.printStackTrace();
	    }
	}
		


	protected String name;
	protected String netid;
	protected int sid;
	protected Rank rank;
	protected ArrayList<Class> classes;
	protected ArrayList<ArrayList<Vector>> snames;
}