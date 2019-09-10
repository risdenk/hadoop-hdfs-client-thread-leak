package io.github.risdenk.hadoop;

import com.carrotsearch.randomizedtesting.RandomizedTest;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestHdfsClientThreadLeak extends RandomizedTest {
  @Rule
  public TemporaryFolder folder= new TemporaryFolder();

  @Test
  public void hdfsClientThreadLeak() throws Exception {
    Configuration conf = new Configuration();
    Path path = new Path(folder.getRoot().toURI());
    try(FileSystem fs = FileSystem.get(path.toUri(), conf)) {
      Assert.assertNotNull(fs);
    }
  }
}
