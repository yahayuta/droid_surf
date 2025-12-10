import 'package:flutter/material.dart';

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  DateTime _selectedDate = DateTime.now();
  TimeOfDay _selectedTime = TimeOfDay.now();
  final TextEditingController _hoursController = TextEditingController();
  final TextEditingController _pointController = TextEditingController();
  final TextEditingController _takeOffController = TextEditingController();
  final TextEditingController _commentController = TextEditingController();

  String? _selectedWeather;
  String? _selectedWind;
  String? _selectedSize;
  String? _selectedCloud;
  String? _selectedBoard;

  final List<String> _weatherOptions = ['Sunny', 'Cloudy', 'Rainy', 'Stormy']; // Placeholder
  final List<String> _windOptions = ['None', 'Light', 'Moderate', 'Strong']; // Placeholder
  final List<String> _sizeOptions = ['Small', 'Medium', 'Large']; // Placeholder
  final List<String> _cloudOptions = ['Clear', 'Partly Cloudy', 'Overcast']; // Placeholder
  final List<String> _boardOptions = ['Shortboard', 'Longboard', 'Funboard']; // Placeholder


  Future<void> _selectDate(BuildContext context) async {
    final DateTime? picked = await showDatePicker(
      context: context,
      initialDate: _selectedDate,
      firstDate: DateTime(2000),
      lastDate: DateTime(2101),
    );
    if (picked != null && picked != _selectedDate) {
      setState(() {
        _selectedDate = picked;
      });
    }
  }

  Future<void> _selectTime(BuildContext context) async {
    final TimeOfDay? picked = await showTimePicker(
      context: context,
      initialTime: _selectedTime,
    );
    if (picked != null && picked != _selectedTime) {
      setState(() {
        _selectedTime = picked;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Surf Record'),
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            // Buttons
            ElevatedButton(
              onPressed: () {
                // Handle forward button press
              },
              child: const Text('Forward'), // @string/button_fwd
            ),
            const SizedBox(height: 8.0),
            ElevatedButton(
              onPressed: () {
                // Handle reverse button press
              },
              child: const Text('Reverse'), // @string/button_bwd
            ),
            const SizedBox(height: 8.0),
            ElevatedButton(
              onPressed: () {
                // Handle delete button press
              },
              child: const Text('Delete'), // @string/button_delete
            ),
            const SizedBox(height: 16.0),

            // Date Picker
            const Text('Day:'), // @string/disp_date
            TextButton(
              onPressed: () => _selectDate(context),
              child: Text('${_selectedDate.toLocal().day}/${_selectedDate.toLocal().month}/${_selectedDate.toLocal().year}'),
            ),
            const SizedBox(height: 16.0),

            // Time Picker
            const Text('Start Time:'), // @string/disp_start_time
            TextButton(
              onPressed: () => _selectTime(context),
              child: Text(_selectedTime.format(context)),
            ),
            const SizedBox(height: 16.0),

            // Hours EditText
            const Text('Hours:'), // @string/disp_time
            TextFormField(
              controller: _hoursController,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                hintText: 'Enter hours',
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 16.0),

            // Point EditText
            const Text('Point:'), // @string/disp_point
            TextFormField(
              controller: _pointController,
              keyboardType: TextInputType.text,
              decoration: const InputDecoration(
                hintText: 'Enter point',
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 16.0),

            // Weather Spinner
            const Text('Weather:'), // @string/disp_weather
            DropdownButtonFormField<String>(
              value: _selectedWeather,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
              ),
              hint: const Text('Select Weather'),
              onChanged: (String? newValue) {
                setState(() {
                  _selectedWeather = newValue;
                });
              },
              items: _weatherOptions.map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
            ),
            const SizedBox(height: 16.0),

            // Wind Spinner
            const Text('Wind:'), // @string/disp_wind
            DropdownButtonFormField<String>(
              value: _selectedWind,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
              ),
              hint: const Text('Select Wind'),
              onChanged: (String? newValue) {
                setState(() {
                  _selectedWind = newValue;
                });
              },
              items: _windOptions.map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
            ),
            const SizedBox(height: 16.0),

            // Size Spinner
            const Text('Size:'), // @string/disp_size
            DropdownButtonFormField<String>(
              value: _selectedSize,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
              ),
              hint: const Text('Select Size'),
              onChanged: (String? newValue) {
                setState(() {
                  _selectedSize = newValue;
                });
              },
              items: _sizeOptions.map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
            ),
            const SizedBox(height: 16.0),

            // Cloud Spinner
            const Text('Cloud:'), // @string/disp_cloud
            DropdownButtonFormField<String>(
              value: _selectedCloud,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
              ),
              hint: const Text('Select Cloud'),
              onChanged: (String? newValue) {
                setState(() {
                  _selectedCloud = newValue;
                });
              },
              items: _cloudOptions.map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
            ),
            const SizedBox(height: 16.0),

            // Board Spinner
            const Text('Board:'), // @string/disp_board
            DropdownButtonFormField<String>(
              value: _selectedBoard,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
              ),
              hint: const Text('Select Board'),
              onChanged: (String? newValue) {
                setState(() {
                  _selectedBoard = newValue;
                });
              },
              items: _boardOptions.map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
            ),
            const SizedBox(height: 16.0),

            // Take Off EditText
            const Text('Take Off:'), // @string/disp_takeoff
            TextFormField(
              controller: _takeOffController,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                hintText: 'Enter take off count',
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 16.0),

            // Comment EditText
            const Text('Comment:'), // @string/disp_comment
            TextFormField(
              controller: _commentController,
              keyboardType: TextInputType.multiline,
              maxLines: null, // Allows for unlimited lines
              decoration: const InputDecoration(
                hintText: 'Enter comments',
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 16.0),

            // Save Button
            ElevatedButton(
              onPressed: () {
                // Handle save button press
              },
              child: const Text('Save'), // @string/button_save
            ),
          ],
        ),
      ),
    );
  }
}
