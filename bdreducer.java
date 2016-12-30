 package BD;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import java.io.IOException;
import java.text.DecimalFormat;


public class bdreducer  extends Reducer <Text,IntWritable,Text,LongWritable> {

	
	long s;
	long c;
	

	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		String k=key.toString();
		for(IntWritable val:values)
		{
			
			s=s+val.get();
			c++;
			}
			context.write(new Text(k), new LongWritable(s/c));

		}
			
   	}
