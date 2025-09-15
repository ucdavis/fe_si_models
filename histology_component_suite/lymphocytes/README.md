This folder documents development and testing of the lymphocytes model

## Model objective
Detection and nuclear segmentation of lymphocytes in feline small intestinal biopsies

## Materials & methods
- **Task type**: Object detection with instance segmentation
- **Model architecture type & platform**: CNN, Aiforia create
- **Combination with other models in aiforia**: This model was chained with 
the models "compartments" and "layers" within Aiforia with layers as the parent 
model, "compartments" only run in recognized layers and "lymphocytes" only run 
in recognized compartments. This strategy can be cost efficient 
although the cost is not completely explainable)
SOP for combining models in aiforia:
https://docs.google.com/presentation/d/1TfTqYD7IXBNtEB0yTfHjLSWQN352mR_C/edit?usp=sharing&ouid=114290326180405247455&rtpof=true&sd=true
- **Tracking of version and combinations**
https://docs.google.com/spreadsheets/d/1Bg5ZT4h1TjjKgKP76iZ03OzNSspau0jlSxPWKsOVVXw/edit?usp=sharing
- **Active version**: fe_si_cells_pv4_mv1 in combinations fe_si_combos_pv2_mv2
- **Development**: This model was developed (trained and tuned) by JMW in aiforia.
Development and testing of its predecessor model (fe_si_cells_pv3_mv11) was
published in https://doi.org/10.1177/0300985824128682.
The differences between the published model and this are:
	- AI engine (updated to allow merging with layers and compartment model)
	- The full development set (training and tuning) used for training (no further tuning performed)
- **Testing**
  - Tested against jmws annotations on aiforia platform
  - Tested against majority annotations of 11 pathologists (as described here)
  https://doi.org/10.1177/03009858241286 documented in 
  fe_si_papers/artificial_intelligence_based_quantification_...

## Subfolders
- **historic** assessment of previous versions are here: 
https://drive.google.com/drive/folders/1eZa68pkrIg8ouJHBsuMQkKQxWZbSlbTn?usp=sharing
  -**annotations_2023-2024**:contains annotations received from aiforia support
  (can now also be fetched with fe_si_platforms/aiforia/scripts/annotations)
  -**tuning_performance_assessment_2021**: excel assessments of predecessor models
  kept for documentation only


