import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
  CartesianGrid,
  Legend
} from 'recharts';

const formatData = (records) =>
  records
    .map((record) => ({
      time: new Date(record.timestamp).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }),
      temperature: Number(record.data.temperature) || null,
      heartRate: Number(record.data.heartRate) || null,
      respRate: Number(record.data.respRate) || null,
      systolic: Number(record.data.bpSystolic) || null,
      diastolic: Number(record.data.bpDiastolic) || null
    }))
    .reverse();

const chartConfigs = [
  {
    key: 'temperature',
    label: 'Temperature (°C)',
    color: '#e85c4a'
  },
  {
    key: 'heartRate',
    label: 'Heart Rate (bpm)',
    color: '#c23730'
  },
  {
    key: 'respRate',
    label: 'Respiratory Rate (breaths/min)',
    color: '#f2a33c'
  }
];

const VitalsCharts = ({ records }) => {
  const data = formatData(records);

  if (!records.length) return null;

  return (
    <div className="card vitals-chart-card">
      <h3>Vital Trends</h3>
      <div className="vitals-charts-grid">
        {chartConfigs.map((cfg) => (
          <div key={cfg.key} className="chart-wrapper">
            <p className="chart-label">{cfg.label}</p>
            <ResponsiveContainer width="100%" height={200}>
              <LineChart data={data}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="time" />
                <YAxis />
                <Tooltip />
                <Line type="monotone" dataKey={cfg.key} stroke={cfg.color} strokeWidth={2} dot={false} />
              </LineChart>
            </ResponsiveContainer>
          </div>
        ))}
        <div className="chart-wrapper full-width">
          <p className="chart-label">Blood Pressure (mmHg)</p>
          <ResponsiveContainer width="100%" height={260}>
            <LineChart data={data}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="time" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Line type="monotone" dataKey="systolic" name="Systolic" stroke="#b32234" strokeWidth={2} />
              <Line type="monotone" dataKey="diastolic" name="Diastolic" stroke="#f2a33c" strokeWidth={2} />
            </LineChart>
          </ResponsiveContainer>
        </div>
      </div>
    </div>
  );
};

export default VitalsCharts;

