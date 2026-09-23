package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {
	private int[] validChannels;
	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	public FilterExtractChannels(int[] validChannels) {
		// TODO
		this.validChannels = validChannels;
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		// TODO
		Measurement[] measurements = eeg.getMeasurements();
		Measurement[] filteredMeasurements = new Measurement[measurements.length];
		
		for (int i =0; i < measurements.length; i++) {
			Measurement totalMeasures = measurements[i];
			int ifiltered = 0;
			float filteredChannels[] = new float[validChannels.length];
			
			for(int j=0; j < totalMeasures.numChannels(); j++) {
				
				for( int k=0; k < validChannels.length; k++) {
					if(totalMeasures.getChannel(j) == validChannels[k]) {
						filteredChannels[ifiltered] = totalMeasures.getChannel(j);
						ifiltered++;
					}
				}
			}
			
			
		}
		
		
		return null;
	}

}
