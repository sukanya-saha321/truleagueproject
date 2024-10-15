package Runner;

import org.apiguardian.api.API;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.core.options.CommandlineOptionsParser;
import io.cucumber.core.options.CucumberProperties;
import io.cucumber.core.options.CucumberPropertiesParser;
import io.cucumber.core.options.RuntimeOptions;
import io.cucumber.core.runtime.Runtime;

@API(status = API.Status.STABLE)
public class CucumberRunner {

	private static final Logger log = LoggerFactory.getLogger(CucumberRunner.class);

	/**
	 * Launches the Cucumber-JVM command line.a
	 *
	 * @param argv runtime options. See details in the
	 *             {@code cucumber.api.cli.Usage.txt} resource.
	 */
	public static void run(String[] args,int sizeOfList,int tagIndex) {
	   run(args, Thread.currentThread().getContextClassLoader(),sizeOfList,tagIndex);
	}

	public static void run2(String[] args) {
		testRunner(args, Thread.currentThread().getContextClassLoader());
		}

	public static void run(String[] arg, ClassLoader classLoader,int sizeOfList,int tagIndex) {
		CommandlineOptionsParser commandlineOptionsParser = null;
		CucumberRunTime runtime = null; 
		
			RuntimeOptions propertiesFileOptions = new CucumberPropertiesParser()
					.parse(CucumberProperties.fromPropertiesFile()).build();

			RuntimeOptions environmentOptions = new CucumberPropertiesParser().parse(CucumberProperties.fromEnvironment())
					.build(propertiesFileOptions);

			RuntimeOptions systemOptions = new CucumberPropertiesParser().parse(CucumberProperties.fromSystemProperties())
					.build(environmentOptions);

		 commandlineOptionsParser = new CommandlineOptionsParser(System.out);
			RuntimeOptions runtimeOptions = commandlineOptionsParser.parse(arg).addDefaultGlueIfAbsent()
					.addDefaultFeaturePathIfAbsent().addDefaultFormatterIfAbsent().addDefaultSummaryPrinterIfAbsent()
					.enablePublishPlugin().build(systemOptions);

			

			runtime = CucumberRunTime.builder().withRuntimeOptions(runtimeOptions).withClassLoader(() -> classLoader)
					.build();
        
			runtime.run(tagIndex,sizeOfList);
			
		}
			
		
		
		
		
	

	public static void testRunner(String[] argv, final ClassLoader classLoader) {
		
			RuntimeOptions propertiesFileOptions = new CucumberPropertiesParser()
					.parse(CucumberProperties.fromPropertiesFile()).build();

			RuntimeOptions environmentOptions = new CucumberPropertiesParser().parse(CucumberProperties.fromEnvironment())
					.build(propertiesFileOptions);

			RuntimeOptions systemOptions = new CucumberPropertiesParser().parse(CucumberProperties.fromSystemProperties())
					.build(environmentOptions);

			CommandlineOptionsParser commandlineOptionsParser = new CommandlineOptionsParser(System.out);
			RuntimeOptions runtimeOptions = commandlineOptionsParser.parse(argv).addDefaultGlueIfAbsent()
					.addDefaultFeaturePathIfAbsent().addDefaultFormatterIfAbsent().addDefaultSummaryPrinterIfAbsent()
					.enablePublishPlugin().build(systemOptions);

			

			Runtime runtime = Runtime.builder().withRuntimeOptions(runtimeOptions).withClassLoader(() -> classLoader)
					.build();

			runtime.run();

	
		
		

	}
	/*public static byte terminator(CommandlineOptionsParser commandlineOptionsParser,Runtime runtime)
	{
		Optional<Byte> exitStatus = commandlineOptionsParser.exitStatus();
		System.out.println("Exit Status "+exitStatus);
		if (exitStatus.isPresent()) {
			System.out.println("Exit status is present");
			return exitStatus.get();
		}
		return runtime.exitStatus();
	}
	*/

}
