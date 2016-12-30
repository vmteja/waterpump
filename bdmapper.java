package BD;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.util.StringTokenizer;

public class bdmapper  extends Mapper <LongWritable,Text,Text,IntWritable> {
	private static Log log = LogFactory.getLog(bdmapper.class);

   	public void map(LongWritable key,Text value, Context context) throws IOException, InterruptedException {
		String installer="";
		int c=0;
		if (key.get() == 0L)
		{
			return; 	//skip  very first record (schema line)
		}


		StringTokenizer iterator = new StringTokenizer(value.toString(),",");
		if(iterator.hasMoreTokens())
		{
		
			for(int i=0;i<2;i++)
			{
				iterator.nextToken();
			}
				
		installer= iterator.nextToken();
		for(int i=0;i<9;i++)
			{
				iterator.nextToken();
			}
		
	
		c=Integer.parseInt(iterator.nextToken());
		if(c!=0)
		{		
	
	    	context.write(new Text(installer), new IntWritable(c));
	    }
	}

	

}
}
